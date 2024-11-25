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

import io.xianzhi.cms.bootstrap.model.dto.ContentDTO;
import io.xianzhi.cms.bootstrap.model.dto.DeletedContentDTO;
import io.xianzhi.cms.bootstrap.model.vo.ContentVO;
import io.xianzhi.cms.bootstrap.service.ContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 内容接口实现
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    /**
     * 创建内容
     *
     * @param contentDTO 内容信息入参
     * @return 创建结果
     * @since 1.0.0
     */
    @Override
    public String createContent(ContentDTO contentDTO) {
        return "";
    }

    /**
     * 更新内容
     *
     * @param contentDTO 内容信息入参
     * @since 1.0.0
     */
    @Override
    public void updateContent(ContentDTO contentDTO) {

    }

    /**
     * 删除内容
     *
     * @param deletedContentDTO 删除内容入参
     * @since 1.0.0
     */
    @Override
    public void deletedContent(DeletedContentDTO deletedContentDTO) {

    }

    /**
     * 查询内容详情
     *
     * @param id       内容ID
     * @param columnId 内容ID
     * @return 内容详情
     * @since 1.0.0
     */
    @Override
    public ContentVO contentDetails(String id, String columnId) {
        return null;
    }

    /**
     * 发布内容
     *
     * @param id       内容ID
     * @param columnId 栏目ID
     * @since 1.0.0
     */
    @Override
    public void publishContent(String id, String columnId) {

    }

    /**
     * 复制内容
     *
     * @param id             内容ID
     * @param columnId       栏目ID
     * @param targetColumnId 目标栏目ID
     * @since 1.0.0
     */
    @Override
    public void copyContent(String id, String columnId, String targetColumnId) {

    }

    /**
     * 移动内容
     *
     * @param id             内容ID
     * @param columnId       栏目ID
     * @param targetColumnId 目标栏目ID
     * @since 1.0.0
     */
    @Override
    public void moveContent(String id, String columnId, String targetColumnId) {

    }

    /**
     * 归档内容
     *
     * @param id       内容ID
     * @param columnId 栏目ID
     * @since 1.0.0
     */
    @Override
    public void archiveContent(String id, String columnId) {

    }
}
