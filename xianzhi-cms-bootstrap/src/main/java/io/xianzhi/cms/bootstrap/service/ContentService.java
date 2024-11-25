package io.xianzhi.cms.bootstrap.service;

import io.xianzhi.cms.bootstrap.model.dto.ContentDTO;
import io.xianzhi.cms.bootstrap.model.dto.DeletedContentDTO;
import io.xianzhi.cms.bootstrap.model.vo.ContentVO;

/**
 * 内容接口
 *
 * @author Max
 * @since 1.0.0
 */
public interface ContentService {
    /**
     * 创建内容
     *
     * @param contentDTO 内容信息入参
     * @return 创建结果
     * @since 1.0.0
     */
    String createContent(ContentDTO contentDTO);

    /**
     * 更新内容
     *
     * @param contentDTO 内容信息入参
     * @since 1.0.0
     */
    void updateContent(ContentDTO contentDTO);

    /**
     * 删除内容
     *
     * @param deletedContentDTO 删除内容入参
     * @since 1.0.0
     */
    void deletedContent(DeletedContentDTO deletedContentDTO);

    /**
     * 查询内容详情
     *
     * @param id       内容ID
     * @param columnId 内容ID
     * @return 内容详情
     * @since 1.0.0
     */
    ContentVO contentDetails(String id, String columnId);

    /**
     * 发布内容
     *
     * @param id       内容ID
     * @param columnId 栏目ID
     * @since 1.0.0
     */
    void publishContent(String id, String columnId);

    /**
     * 复制内容
     *
     * @param id             内容ID
     * @param columnId       栏目ID
     * @param targetColumnId 目标栏目ID
     * @since 1.0.0
     */
    void copyContent(String id, String columnId, String targetColumnId);

    /**
     * 移动内容
     *
     * @param id             内容ID
     * @param columnId       栏目ID
     * @param targetColumnId 目标栏目ID
     * @since 1.0.0
     */
    void moveContent(String id, String columnId, String targetColumnId);

    /**
     * 归档内容
     *
     * @param id       内容ID
     * @param columnId 栏目ID
     * @since 1.0.0
     */
    void archiveContent(String id, String columnId);
}
