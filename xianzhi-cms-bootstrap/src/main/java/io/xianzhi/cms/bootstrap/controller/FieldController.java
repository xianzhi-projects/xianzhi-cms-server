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
import io.xianzhi.cms.bootstrap.model.dto.FieldDTO;
import io.xianzhi.cms.bootstrap.model.vo.FieldVO;
import io.xianzhi.core.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字段管理接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/field")
public class FieldController {

    /**
     * 保存字段
     *
     * @param modelId 模型ID
     * @param fields  字段信息
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:field:saveField')")
    @PostMapping("/saveField/{modelId}")
    public ResponseResult<Object> saveField(@PathVariable(value = "modelId") String modelId, @RequestBody List<FieldDTO> fields) {
        return ResponseResult.ok();
    }

    /**
     * 查询模型字段
     *
     * @param modelId 模型ID
     * @return 字段信息
     * @since 1.0.0
     */
    @PreAuthorize("@xz.hasPermission('cms:field:saveField')")
    @GetMapping("/listField/{modelId}")
    public ResponseResult<List<FieldVO>> listField(@PathVariable(value = "modelId") String modelId) {
        return ResponseResult.ok();
    }
}
