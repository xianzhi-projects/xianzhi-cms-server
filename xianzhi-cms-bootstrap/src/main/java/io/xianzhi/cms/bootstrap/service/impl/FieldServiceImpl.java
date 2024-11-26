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

import io.xianzhi.cms.bootstrap.model.dto.FieldDTO;
import io.xianzhi.cms.bootstrap.model.vo.FieldVO;
import io.xianzhi.cms.bootstrap.service.FieldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字段接口实现
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements FieldService {

    /**
     * 模型ID获取字段信息
     *
     * @param modelId 模型ID
     * @return 字段信息
     * @since 1.0.0
     */
    @Override
    public List<FieldVO> getFieldsByModelId(String modelId) {
        return List.of();
    }

    /**
     * 保存字段
     *
     * @param modelId 模型ID
     * @param fields  字段信息
     * @since 1.0.0
     */
    @Override
    public void saveField(String modelId, List<FieldDTO> fields) {

    }
}
