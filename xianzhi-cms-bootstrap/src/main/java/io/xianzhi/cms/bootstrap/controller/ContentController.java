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

package io.xianzhi.cms.bootstrap.controller;

import io.xianzhi.cms.bootstrap.annotations.AuditLog;
import io.xianzhi.cms.bootstrap.model.dto.ContentDTO;
import io.xianzhi.cms.bootstrap.model.dto.DeletedContentDTO;
import io.xianzhi.cms.bootstrap.model.vo.ContentVO;
import io.xianzhi.cms.bootstrap.service.ContentService;
import io.xianzhi.core.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 内容管理接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentController {

    /**
     * 内容服务
     */
    private final ContentService contentService;

    /**
     * 创建内容
     *
     * @param contentDTO 内容信息入参
     * @return 创建结果
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:content:createContent')")
    @PostMapping("/createContent")
    public ResponseResult<String> createContent(@RequestBody @Validated ContentDTO contentDTO) {
        return ResponseResult.ok(contentService.createContent(contentDTO));
    }

    /**
     * 更新内容
     *
     * @param contentDTO 内容信息入参
     * @return 更新结果
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:content:updateContent')")
    @PostMapping("/updateContent")
    public ResponseResult<Object> updateContent(@RequestBody @Validated ContentDTO contentDTO) {
        contentService.updateContent(contentDTO);
        return ResponseResult.ok();
    }

    /**
     * 删除内容
     *
     * @param deletedContentDTO 删除内容入参
     * @return 删除结果
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:content:deletedContent')")
    @PostMapping("/deletedContent")
    public ResponseResult<Object> deletedContent(@RequestBody @Validated DeletedContentDTO deletedContentDTO) {
        contentService.deletedContent(deletedContentDTO);
        return ResponseResult.ok();
    }

    /**
     * 查询内容详情
     *
     * @param id       内容ID
     * @param columnId 内容ID
     * @return 内容详情
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:content:contentDetails')")
    @GetMapping(value = "/contentDetails/{columnId}")
    public ResponseResult<ContentVO> contentDetails(@RequestParam String id, @PathVariable(value = "columnId") String columnId) {
        return ResponseResult.ok(contentService.contentDetails(id, columnId));
    }

    /**
     * 发布内容
     *
     * @param id       内容ID
     * @param columnId 栏目ID
     * @return 发布结果
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:content:publishContent')")
    @PostMapping("/publishContent/{columnId}")
    public ResponseResult<Object> publishContent(@RequestParam String id, @PathVariable(value = "columnId") String columnId) {
        contentService.publishContent(id, columnId);
        return ResponseResult.ok();
    }

    /**
     * 复制内容
     *
     * @param id             内容ID
     * @param columnId       栏目ID
     * @param targetColumnId 目标栏目ID
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:content:copyContent')")
    @PostMapping("/copyContent/{columnId}")
    public ResponseResult<Object> copyContent(@RequestParam String id, @PathVariable(value = "columnId") String columnId, @RequestParam String targetColumnId) {
        contentService.copyContent(id, columnId, targetColumnId);
        return ResponseResult.ok();
    }

    /**
     * 移动内容
     *
     * @param id             内容ID
     * @param columnId       栏目ID
     * @param targetColumnId 目标栏目ID
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:content:moveContent')")
    @PostMapping("/moveContent/{columnId}")
    public ResponseResult<Object> moveContent(@RequestParam String id, @PathVariable(value = "columnId") String columnId, @RequestParam String targetColumnId) {
        contentService.moveContent(id, columnId, targetColumnId);
        return ResponseResult.ok();
    }

    /**
     * 归档内容
     *
     * @param id       内容ID
     * @param columnId 栏目ID
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:content:archiveContent')")
    @PostMapping("/archiveContent/{columnId}")
    public ResponseResult<Object> archiveContent(@RequestParam(value = "id") String id, @PathVariable(value = "columnId") String columnId) {
        contentService.archiveContent(id, columnId);
        return ResponseResult.ok();
    }
}
