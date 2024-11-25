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

import io.xianzhi.cms.bootstrap.business.AuditTemplateBusiness;
import io.xianzhi.cms.bootstrap.model.dto.AuditTemplateDTO;
import io.xianzhi.cms.bootstrap.model.page.AuditTemplatePage;
import io.xianzhi.cms.bootstrap.model.vo.AuditTemplateVO;
import io.xianzhi.cms.bootstrap.service.AuditTemplateService;
import io.xianzhi.core.result.ListResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 审计日志模板处理
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuditTemplateServiceImpl implements AuditTemplateService {
    /**
     * 审计模板业务类
     */
    private final AuditTemplateBusiness auditTemplateBusiness;




    /**
     * 创建审计日志模板
     *
     * @param auditTemplateDTO 审计日志模板信息
     * @return 模板ID
     * @since 1.0.0
     */
    @Override
    public String createAuditTemplate(AuditTemplateDTO auditTemplateDTO) {
        return "";
    }

    /**
     * 修改审计日志模板
     *
     * @param auditTemplateDTO 审计日志模板信息
     * @since 1.0.0
     */
    @Override
    public void updateAuditTemplate(AuditTemplateDTO auditTemplateDTO) {

    }

    /**
     * 删除审计日志模板
     *
     * @param ids 审计日志模板ID
     * @since 1.0.0
     */
    @Override
    public void deleteAuditTemplate(List<String> ids) {

    }

    /**
     * 启用审计日志模板
     *
     * @param ids 审计日志模板ID
     * @since 1.0.0
     */
    @Override
    public void enableAuditTemplate(List<String> ids) {

    }

    /**
     * 禁用审计日志模板
     *
     * @param ids 审计日志模板ID
     * @since 1.0.0
     */
    @Override
    public void disableAuditTemplate(List<String> ids) {

    }

    /**
     * 分页查询审计日志模板列表
     *
     * @param auditTemplatePage 分页查询条件
     * @return 审计日志模板列表
     * @since 1.0.0
     */
    @Override
    public ListResult<AuditTemplateVO> pageAuditTemplateList(AuditTemplatePage auditTemplatePage) {
        return null;
    }
}
