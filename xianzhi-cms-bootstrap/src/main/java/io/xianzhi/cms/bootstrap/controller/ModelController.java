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
import io.xianzhi.cms.bootstrap.model.dto.ModelDTO;
import io.xianzhi.cms.bootstrap.model.page.ModelPage;
import io.xianzhi.cms.bootstrap.model.vo.ModelVO;
import io.xianzhi.cms.bootstrap.service.ModelService;
import io.xianzhi.core.result.ListResult;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.validated.Create;
import io.xianzhi.core.validated.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 模型管理接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/model")
public class ModelController {


    /**
     * 模型服务
     */
    private final ModelService modelService;


    /**
     * 新增模型
     *
     * @param modelDTO 模型信息
     * @return 模型ID
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:model:createModel')")
    @PostMapping("/createModel")
    public ResponseResult<String> createModel(@RequestBody @Validated(value = Create.class) ModelDTO modelDTO) {
        return ResponseResult.ok(modelService.createModel(modelDTO));
    }

    /**
     * 修改模型
     *
     * @param modelDTO 模型信息
     * @return 响应信息
     * @since 1.0.0
     */
    @AuditLog
    @PreAuthorize("@xz.hasPermission('cms:model:updateModel')")
    @PostMapping("/updateModel")
    public ResponseResult<Object> updateModel(@RequestBody @Validated(value = Update.class) ModelDTO modelDTO) {
        modelService.updateModel(modelDTO);
        return ResponseResult.ok();
    }

    /**
     * 查询简单模型列表
     *
     * @return 简单模型列表
     * @since 1.0.0
     */
    @PreAuthorize("@xz.hasPermission('cms:column:createColumn','cms:column:updateColumn')")
    @GetMapping("/getSimpleModelList")
    public ResponseResult<List<ModelVO>> getSimpleModelList() {
        return ResponseResult.ok(modelService.getSimpleModelList());
    }

    /**
     * 查询模型列表
     *
     * @param modelPage 模型分页信息
     * @return 模型列表
     * @since 1.0.0
     */
    @PostMapping("/pageModelList")
    public ResponseResult<ListResult<ModelVO>> pageModelList(@RequestBody ModelPage modelPage) {
        return ResponseResult.ok(modelService.pageModelList(modelPage));
    }

    /**
     * 为模型分配站点，模型需要是私有模型
     *
     * @param modelId 模型ID
     * @param siteIds 站点ID
     * @return 响应信息
     * @since 1.0.0
     */
    @PostMapping("/distributionModel/{modelId}")
    public ResponseResult<Object> distributionModel(@PathVariable(value = "modelId") String modelId, @RequestBody List<String> siteIds) {
        modelService.distributionModel(modelId, siteIds);
        return ResponseResult.ok();
    }
}
