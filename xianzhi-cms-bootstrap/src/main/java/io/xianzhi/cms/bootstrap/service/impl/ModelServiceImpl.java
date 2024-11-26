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

package io.xianzhi.cms.bootstrap.service.impl;

import io.xianzhi.cms.bootstrap.business.ModelBusiness;
import io.xianzhi.cms.bootstrap.dao.dataobj.ModelDO;
import io.xianzhi.cms.bootstrap.dao.mapper.ModelMapper;
import io.xianzhi.cms.bootstrap.model.code.ModelCode;
import io.xianzhi.cms.bootstrap.model.dto.ModelDTO;
import io.xianzhi.cms.bootstrap.model.page.ModelPage;
import io.xianzhi.cms.bootstrap.model.vo.ModelVO;
import io.xianzhi.cms.bootstrap.processor.SqlProcessor;
import io.xianzhi.cms.bootstrap.service.ModelService;
import io.xianzhi.core.exception.BusinessException;
import io.xianzhi.core.result.ListResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 模型接口实现
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    /**
     * 模型信息持久层
     */
    private final ModelMapper modelMapper;

    /**
     * 模型业务类
     */
    private final ModelBusiness modelBusiness;

    /**
     * SQL处理
     */
    private final SqlProcessor sqlProcessor;

    /**
     * 新增模型
     *
     * @param modelDTO 模型信息
     * @return 模型ID
     * @since 1.0.0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createModel(ModelDTO modelDTO) {
        ModelDO model = checkedModelDTO(modelDTO);
        modelMapper.insert(model);
        sqlProcessor.createTable(model.getModelTableName());
        return model.getId();
    }

    /**
     * 修改模型
     *
     * @param modelDTO 模型信息
     * @since 1.0.0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateModel(ModelDTO modelDTO) {

    }

    /**
     * 查询简单模型列表
     *
     * @return 简单模型列表
     * @since 1.0.0
     */
    @Override
    public List<ModelVO> getSimpleModelList() {
        return List.of();
    }

    /**
     * 查询模型列表
     *
     * @param modelPage 模型分页信息
     * @return 模型列表
     * @since 1.0.0
     */
    @Override
    public ListResult<ModelVO> pageModelList(ModelPage modelPage) {
        return null;
    }

    /**
     * 为模型分配站点，模型需要是私有模型
     *
     * @param modelId 模型ID
     * @param siteIds 站点ID
     * @since 1.0.0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void distributionModel(String modelId, List<String> siteIds) {

    }

    /**
     * 检查模型入参
     *
     * @param modelDTO 模型信息入参
     * @return 模型信息实体
     * @since 1.0.0
     */
    private ModelDO checkedModelDTO(ModelDTO modelDTO) {
        ModelDO model;
        if (StringUtils.hasText(modelDTO.getId())) {
            model = modelBusiness.getModelByIdOrThrow(modelDTO.getId());
        } else {
            model = new ModelDO();
            if (modelMapper.existsModelByTableNameAndIdNot(modelDTO.getModelTableName(), null)) {
                log.error("模型表名已存在,模型表名:{}", modelDTO.getModelTableName());
                throw new BusinessException(ModelCode.MODEL_TABLE_NAME_EXIST);
            }
            model.setModelTableName(modelDTO.getModelTableName());
        }
        if (modelMapper.existsModelByModelNameAndIdNot(modelDTO.getModelName(), model.getId())) {
            log.error("模型名称已存在,模型名称:{}", modelDTO.getModelName());
            throw new BusinessException(ModelCode.MODEL_NAME_EXIST);
        }
        model.setModelName(modelDTO.getModelName());
        model.setModelDesc(modelDTO.getModelDesc());
        model.setModelSort(modelDTO.getModelSort());
        model.setModelType(modelDTO.getModelType());
        model.setCommonFlag(modelDTO.getCommonFlag());
        return model;

    }
}
