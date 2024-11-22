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
 * Controller for managing resource operations.
 * <p>
 * This class handles API requests under the "/resource" path.
 * </p>
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/resource")
public class ResourceController {

    /**
     * Resource service.
     */
    private final ResourceService resourceService;

    /**
     * Create a new resource.
     *
     * @param resourceDTO resource data
     * @return resource ID
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/createResource")
    public ResponseResult<String> creteResource(@RequestBody @Validated(value = Create.class) ResourceDTO resourceDTO) {
        return ResponseResult.ok(resourceService.createResource(resourceDTO));
    }

    /**
     * Update the resource.
     *
     * @param resourceDTO resource data
     * @return resource ID
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping("/updateResource")
    public ResponseResult<Object> updateResource(@RequestBody @Validated(value = Update.class) ResourceDTO resourceDTO) {
        resourceService.updateResource(resourceDTO);
        return ResponseResult.ok();
    }

    /**
     * Retrieves all system resource information and converts it into a tree structure.
     *
     * @return resources structured as a tree.
     * @since 1.0.0
     */
    @GetMapping("/tree")
    public ResponseResult<List<ResourceVO>> tree() {
        return ResponseResult.ok(resourceService.tree());
    }
}
