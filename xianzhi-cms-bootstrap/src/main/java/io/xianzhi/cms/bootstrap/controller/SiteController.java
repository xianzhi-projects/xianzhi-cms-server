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
import io.xianzhi.cms.bootstrap.model.dto.SiteDTO;
import io.xianzhi.cms.bootstrap.service.SiteService;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.validated.Create;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing site operations.
 * <p>
 * This class handles API requests under the "/site" path.
 * </p>
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/site")
public class SiteController {

    /**
     * Site service.
     */
    private final SiteService siteService;

    /**
     * Creates a new site.
     *
     * @param siteDTO The site data to be created.
     * @return Site id
     */
    @AuditLog
    @PostMapping(value = "/createNewSite")
    public ResponseResult<String> createNewSite(@RequestBody @Validated(value = Create.class) SiteDTO siteDTO) {
        return ResponseResult.ok(siteService.createNewSite(siteDTO));
    }
}