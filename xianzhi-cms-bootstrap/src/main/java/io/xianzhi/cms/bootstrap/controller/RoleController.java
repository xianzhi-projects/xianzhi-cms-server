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

import io.xianzhi.cms.bootstrap.model.dto.RoleDTO;
import io.xianzhi.core.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色管理接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/role")
public class RoleController {

    /**
     * 创建角色
     *
     * @param roleDTO 角色信息
     * @return 角色ID
     * @since 1.0.0
     */
    public ResponseResult<String> createRole(RoleDTO roleDTO) {
        return ResponseResult.ok();
    }

    /**
     * 更新角色
     *
     * @param roleDTO 角色信息
     * @return 响应信息
     * @since 1.0.0
     */
    public ResponseResult<Object> updateRole(RoleDTO roleDTO) {
        return ResponseResult.ok();
    }

    /**
     * 删除角色
     *
     * @param ids 角色ID列表
     * @return 响应信息
     * @since 1.0.0
     */
    public ResponseResult<Object> deletedRole(List<String> ids) {
        return ResponseResult.ok();
    }
}
