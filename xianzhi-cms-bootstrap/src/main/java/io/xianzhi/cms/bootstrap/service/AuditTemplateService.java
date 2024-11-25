package io.xianzhi.cms.bootstrap.service;


import io.xianzhi.cms.bootstrap.model.dto.AuditTemplateDTO;
import io.xianzhi.cms.bootstrap.model.page.AuditTemplatePage;
import io.xianzhi.cms.bootstrap.model.vo.AuditTemplateVO;
import io.xianzhi.core.result.ListResult;

import java.util.List;

/**
 * 审计模板接口
 *
 * @author Max
 * @since 1.0.0
 */
public interface AuditTemplateService {
    /**
     * 创建审计日志模板
     *
     * @param auditTemplateDTO 审计日志模板信息
     * @return 模板ID
     * @since 1.0.0
     */
    String createAuditTemplate(AuditTemplateDTO auditTemplateDTO);

    /**
     * 修改审计日志模板
     *
     * @param auditTemplateDTO 审计日志模板信息
     * @since 1.0.0
     */
    void updateAuditTemplate(AuditTemplateDTO auditTemplateDTO);

    /**
     * 删除审计日志模板
     *
     * @param ids 审计日志模板ID
     * @since 1.0.0
     */
    void deleteAuditTemplate(List<String> ids);

    /**
     * 启用审计日志模板
     *
     * @param ids 审计日志模板ID
     * @since 1.0.0
     */
    void enableAuditTemplate(List<String> ids);

    /**
     * 禁用审计日志模板
     *
     * @param ids 审计日志模板ID
     * @since 1.0.0
     */
    void disableAuditTemplate(List<String> ids);

    /**
     * 分页查询审计日志模板列表
     *
     * @param auditTemplatePage 分页查询条件
     * @return 审计日志模板列表
     * @since 1.0.0
     */
    ListResult<AuditTemplateVO> pageAuditTemplateList(AuditTemplatePage auditTemplatePage);
}
