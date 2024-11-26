package io.xianzhi.cms.bootstrap.service;

import io.xianzhi.cms.bootstrap.model.dto.ColumnDTO;

/**
 * 栏目接口
 * @author Max
 * @since 1.0.0
 */
public interface ColumnService {

    /**
     * 创建栏目
     * @param columnDTO 栏目信息
     * @return 栏目ID
     */
    String createColumn(ColumnDTO columnDTO);

    /**
     * 更新栏目
     * @param columnDTO 栏目信息
     */
    void updateColumn(ColumnDTO columnDTO);
}
