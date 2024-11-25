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
import io.xianzhi.cms.bootstrap.dao.mapper.ModelMapper;
import io.xianzhi.cms.bootstrap.model.dto.ModelDTO;
import io.xianzhi.cms.bootstrap.model.page.ModelPage;
import io.xianzhi.cms.bootstrap.model.vo.ModelVO;
import io.xianzhi.cms.bootstrap.service.ModelService;
import io.xianzhi.core.result.ListResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
     * 新增模型
     *
     * @param modelDTO 模型信息
     * @return 模型ID
     * @since 1.0.0
     */
    @Override
    public String createModel(ModelDTO modelDTO) {
        return "";
    }

    /**
     * 修改模型
     *
     * @param modelDTO 模型信息
     * @since 1.0.0
     */
    @Override
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
     * @return 响应信息
     * @since 1.0.0
     */
    @Override
    public void distributionModel(String modelId, List<String> siteIds) {

    }
}
