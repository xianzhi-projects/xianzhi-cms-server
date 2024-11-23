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

import io.xianzhi.cms.bootstrap.model.dto.AuditTemplateDTO;
import io.xianzhi.core.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 审计日志模板接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auditTemplate")
public class AuditTemplateController {

    /**
     * 创建审计日志模板
     *
     * @param auditTemplateDTO 审计日志模板信息
     * @return 模板ID
     * @since 1.0.0
     */
    @PostMapping("/createAuditTemplate")
    public ResponseResult<String> createAuditTemplate(@RequestBody @Validated AuditTemplateDTO auditTemplateDTO) {
        return ResponseResult.ok();
    }
}
