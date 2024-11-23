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
import io.xianzhi.cms.bootstrap.model.dto.ResourceDTO;
import io.xianzhi.cms.bootstrap.model.vo.ResourceVO;
import io.xianzhi.cms.bootstrap.service.ResourceService;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.validated.Create;
import io.xianzhi.core.validated.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源管理接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/resource")
public class ResourceController {

    /**
     * 资源服务
     */
    private final ResourceService resourceService;

    /**
     * 新增一个资源信息
     *
     * @param resourceDTO 资源信息入参
     * @return 资源 ID
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/createResource")
    public ResponseResult<String> creteResource(@RequestBody @Validated(value = Create.class) ResourceDTO resourceDTO) {
        return ResponseResult.ok(resourceService.createResource(resourceDTO));
    }

    /**
     * 修改资源
     *
     * @param resourceDTO 资源信息入参
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/updateResource")
    public ResponseResult<Object> updateResource(@RequestBody @Validated(value = Update.class) ResourceDTO resourceDTO) {
        resourceService.updateResource(resourceDTO);
        return ResponseResult.ok();
    }

    /**
     * 查询系统资源树形结构
     *
     * @return 系统所有资源树形结构
     * @since 1.0.0
     */
    @GetMapping("/tree")
    public ResponseResult<List<ResourceVO>> tree() {
        return ResponseResult.ok(resourceService.tree());
    }

    /**
     * 查询当前用户的资源信息
     *
     * @return 当前用户的资源信息
     * @since 1.0.0
     */
    @GetMapping("/getCurrentUserResource")
    public ResponseResult<List<ResourceVO>> getCurrentUserResource() {
        return ResponseResult.ok(resourceService.getCurrentUserResource());
    }
}
