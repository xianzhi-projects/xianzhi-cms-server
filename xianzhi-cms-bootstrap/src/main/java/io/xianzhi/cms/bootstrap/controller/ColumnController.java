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
import io.xianzhi.cms.bootstrap.model.dto.ColumnDTO;
import io.xianzhi.core.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 栏目接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/column")
public class ColumnController {
    /**
     * 创建栏目
     *
     * @param columnDTO 栏目信息入参
     * @return 栏目ID
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:column:createColumn')")
    @PostMapping("/createColumn")
    public ResponseResult<String> createColumn(@RequestBody @Validated ColumnDTO columnDTO) {
        return ResponseResult.ok("create column success");
    }

    /**
     * 修改栏目
     *
     * @param columnDTO 栏目信息入参
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:column:updateColumn')")
    @PostMapping("/updateColumn")
    public ResponseResult<Object> updateColumn(@RequestBody @Validated ColumnDTO columnDTO) {
        return ResponseResult.ok();
    }

    /**
     * 删除栏目
     *
     * @param id 栏目ID
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:column:deletedColumn')")
    @PostMapping("/deletedColumn/{id}")
    public ResponseResult<Object> deletedColumn(@PathVariable(value = "id") String id) {
        return ResponseResult.ok();
    }

}
