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

import io.xianzhi.cms.bootstrap.model.dto.ColumnDTO;
import io.xianzhi.cms.bootstrap.service.ColumnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 栏目接口实现
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ColumnServiceImpl implements ColumnService {
    /**
     * 创建栏目
     *
     * @param columnDTO 栏目信息
     * @return 栏目ID
     */
    @Override
    public String createColumn(ColumnDTO columnDTO) {
        return "";
    }

    /**
     * 更新栏目
     *
     * @param columnDTO 栏目信息
     */
    @Override
    public void updateColumn(ColumnDTO columnDTO) {

    }
}
