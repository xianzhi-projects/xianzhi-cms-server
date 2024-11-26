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
import io.xianzhi.cms.bootstrap.model.dto.OrganizationDTO;
import io.xianzhi.cms.bootstrap.service.OrganizationService;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.validated.Create;
import io.xianzhi.core.validated.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 组织机构管理接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/organization")
public class OrganizationController {

    /**
     * 组织机构服务
     */
    private final OrganizationService organizationService;

    /**
     * 创建组织机构
     *
     * @param organizationDTO 组织机构信息
     * @return 创建结果
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/createOrganization")
    public ResponseResult<String> createOrganization(@RequestBody @Validated(value = Create.class) OrganizationDTO organizationDTO) {
        return ResponseResult.ok("");
    }

    /**
     * 更新组织机构
     *
     * @param organizationDTO 组织机构信息
     * @return 更新结果
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/updateOrganization")
    public ResponseResult<Object> updateOrganization(@RequestBody @Validated(value = Update.class) OrganizationDTO organizationDTO) {
        return ResponseResult.ok();
    }

    /**
     * 删除组织机构
     *
     * @param organizationId 组织机构ID
     * @return 删除结果
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/deletedOrganization/{organizationId}")
    public ResponseResult<Object> deletedOrganization(@PathVariable(value = "organizationId") String organizationId) {
        return ResponseResult.ok();
    }
}
