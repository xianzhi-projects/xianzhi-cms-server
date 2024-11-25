/*
 * Copyright 2024 XianZhi Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.xianzhi.cms.bootstrap.business;

import io.xianzhi.boot.redis.RedisProcessor;
import io.xianzhi.cms.bootstrap.constants.ModelCacheKeyConstant;
import io.xianzhi.cms.bootstrap.dao.dataobj.ModelDO;
import io.xianzhi.cms.bootstrap.dao.mapper.ModelMapper;
import io.xianzhi.cms.bootstrap.model.code.ModelCode;
import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * 模型业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ModelBusiness {

    /**
     * 模型信息持久层
     */
    private final ModelMapper modelMapper;

    /**
     * 缓存处理
     */
    private final RedisProcessor redisProcessor;

    /**
     * 根据模型ID查询模型信息,如果模型模型不存在则抛出异常
     *
     * @param modelId 模型ID
     * @return 模型信息
     */
    public ModelDO getModelByIdOrThrow(String modelId) {
        return getModelById(modelId).orElseThrow(() -> {
            log.error("根据模型ID查询模型信息为空,模型ID:{}", modelId);
            return new BusinessException(ModelCode.MODEL_NOT_EXIST);
        });
    }

    /**
     * 根据模型ID查询模型信息
     *
     * @param modelId 模型ID
     * @return 模型信息
     */
    public Optional<ModelDO> getModelById(String modelId) {
        if (StringUtils.hasText(modelId)) {
            ModelDO model = redisProcessor.vGet(String.format(ModelCacheKeyConstant.MODEL_CACHE_ID, modelId), ModelDO.class);
            if (null == model) {
                Optional<ModelDO> modelOp = modelMapper.selectModelById(modelId);
                if (modelOp.isPresent()) {
                    model = modelOp.get();
                    redisProcessor.vSet(String.format(ModelCacheKeyConstant.MODEL_CACHE_ID, modelId), model);
                } else {
                    model = new ModelDO();
                    redisProcessor.vSet(String.format(ModelCacheKeyConstant.MODEL_CACHE_ID, modelId), model);
                }
            }
            return StringUtils.hasText(model.getId()) ? Optional.of(model) : Optional.empty();
        }
        log.error("根据模型ID查询模型信息失败,模型ID不能为空");
        throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
    }


}
