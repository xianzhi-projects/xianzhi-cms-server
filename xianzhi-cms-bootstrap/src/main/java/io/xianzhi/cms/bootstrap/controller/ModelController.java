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
import io.xianzhi.cms.bootstrap.model.dto.ModelDTO;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.validated.Create;
import io.xianzhi.core.validated.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模型管理接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/model")
public class ModelController {


    /**
     * 新增模型
     *
     * @param modelDTO 模型信息
     * @return 模型ID
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:model:createModel')")
    @PostMapping("/createModel")
    public ResponseResult<String> createModel(@RequestBody @Validated(value = Create.class) ModelDTO modelDTO) {
        return ResponseResult.ok();
    }

    /**
     * 修改模型
     *
     * @param modelDTO 模型信息
     * @return 响应信息
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:model:updateModel')")
    @PostMapping("/updateModel")
    public ResponseResult<Object> updateModel(@RequestBody @Validated(value = Update.class) ModelDTO modelDTO) {
        return ResponseResult.ok();
    }
}
