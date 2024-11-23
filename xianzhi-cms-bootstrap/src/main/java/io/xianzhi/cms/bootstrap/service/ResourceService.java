package io.xianzhi.cms.bootstrap.service;

import io.xianzhi.cms.bootstrap.model.dto.ResourceDTO;
import io.xianzhi.cms.bootstrap.model.vo.ResourceVO;

import java.util.List;

/**
 * 资源接口
 * @author Max
 * @since 1.0.0
 */
public interface ResourceService {
    /**
     * Create a new resource.
     *
     * @param resourceDTO resource data
     * @return resource ID
     * @since 1.0.0
     */
    String createResource(ResourceDTO resourceDTO);

    /**
     * Update the resource.
     *
     * @param resourceDTO resource data
     * @since 1.0.0
     */
    void updateResource(ResourceDTO resourceDTO);

    /**
     * Retrieves all system resource information and converts it into a tree structure.
     *
     * @return resources structured as a tree.
     * @since 1.0.0
     */
    List<ResourceVO> tree();
}
