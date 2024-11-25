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
import io.xianzhi.cms.bootstrap.model.dto.AuditTemplateDTO;
import io.xianzhi.cms.bootstrap.model.page.AuditTemplatePage;
import io.xianzhi.cms.bootstrap.model.vo.AuditTemplateVO;
import io.xianzhi.cms.bootstrap.service.AuditTemplateService;
import io.xianzhi.core.result.ListResult;
import io.xianzhi.core.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 审计日志模板服务
     */
    private final AuditTemplateService auditTemplateService;

    /**
     * 创建审计日志模板
     *
     * @param auditTemplateDTO 审计日志模板信息
     * @return 模板ID
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/createAuditTemplate")
    public ResponseResult<String> createAuditTemplate(@RequestBody @Validated AuditTemplateDTO auditTemplateDTO) {
        return ResponseResult.ok(auditTemplateService.createAuditTemplate(auditTemplateDTO));
    }

    /**
     * 修改审计日志模板
     *
     * @param auditTemplateDTO 审计日志模板信息
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/updateAuditTemplate")
    public ResponseResult<Object> updateAuditTemplate(@RequestBody @Validated AuditTemplateDTO auditTemplateDTO) {
        auditTemplateService.updateAuditTemplate(auditTemplateDTO);
        return ResponseResult.ok();
    }

    /**
     * 删除审计日志模板
     *
     * @param ids 审计日志模板ID
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/deleteAuditTemplate")
    public ResponseResult<Object> deleteAuditTemplate(@RequestBody List<String> ids) {
        auditTemplateService.deleteAuditTemplate(ids);
        return ResponseResult.ok();
    }

    /**
     * 启用审计日志模板
     *
     * @param ids 审计日志模板ID
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/enableAuditTemplate")
    public ResponseResult<Object> enableAuditTemplate(@RequestBody List<String> ids) {
        auditTemplateService.enableAuditTemplate(ids);
        return ResponseResult.ok();
    }

    /**
     * 禁用审计日志模板
     *
     * @param ids 审计日志模板ID
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/disableAuditTemplate")
    public ResponseResult<Object> disableAuditTemplate(@RequestBody List<String> ids) {
        auditTemplateService.disableAuditTemplate(ids);
        return ResponseResult.ok();
    }

    /**
     * 分页查询审计日志模板列表
     *
     * @param auditTemplatePage 分页查询条件
     * @return 审计日志模板列表
     * @since 1.0.0
     */
    @PostMapping("/pageAuditTemplateList")
    public ResponseResult<ListResult<AuditTemplateVO>> pageAuditTemplateList(AuditTemplatePage auditTemplatePage) {
        return ResponseResult.ok(auditTemplateService.pageAuditTemplateList(auditTemplatePage));
    }
}
