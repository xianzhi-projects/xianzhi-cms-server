package io.xianzhi.cms.bootstrap.service;

import io.xianzhi.cms.bootstrap.model.dto.RoleDTO;

/**
 * 角色接口
 *
 * @author Max
 * @since 1.0.0
 */
public interface RoleService {


    /**
     * 新增角色
     *
     * @param roleDTO 角色信息入参
     * @return 角色ID
     */
    String createRole(RoleDTO roleDTO);
}
