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

import io.xianzhi.cms.bootstrap.model.dto.ColumnDTO;
import io.xianzhi.core.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 栏目接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/column")
public class ColumnController {
    /**
     * 创建栏目
     *
     * @param columnDTO 栏目信息入参
     * @return 栏目ID
     * @since 1.0.0
     */
    @PostMapping("/createColumn")
    public ResponseResult<String> createColumn(@RequestBody @Validated ColumnDTO columnDTO) {
        return ResponseResult.ok("create column success");
    }
}
