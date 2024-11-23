package io.xianzhi.cms.bootstrap.service;

import io.xianzhi.cms.bootstrap.model.dto.ResourceDTO;
import io.xianzhi.cms.bootstrap.model.vo.ResourceVO;

import java.util.List;

/**
 * 资源接口
 *
 * @author Max
 * @since 1.0.0
 */
public interface ResourceService {
    /**
     * 新增资源信息
     *
     * @param resourceDTO 资源信息入参
     * @return 资源ID
     * @since 1.0.0
     */
    String createResource(ResourceDTO resourceDTO);

    /**
     * 修改资源
     *
     * @param resourceDTO 资源信息入参
     * @since 1.0.0
     */
    void updateResource(ResourceDTO resourceDTO);

    /**
     * 查询系统资源树
     *
     * @return 资源树信息
     * @since 1.0.0
     */
    List<ResourceVO> tree();

    /**
     * 获取当前用户的资源信息
     *
     * @return 当前用户资源信息
     * @since 1.0.0
     */
    List<ResourceVO> getCurrentUserResource();
}
