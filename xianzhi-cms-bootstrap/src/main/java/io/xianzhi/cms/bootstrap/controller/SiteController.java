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
import io.xianzhi.cms.bootstrap.model.page.SitePage;
import io.xianzhi.cms.bootstrap.model.vo.SiteVO;
import io.xianzhi.cms.bootstrap.service.SiteService;
import io.xianzhi.core.result.ListResult;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.validated.Create;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 站点管理接口
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
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping(value = "/createNewSite")
    public ResponseResult<String> createNewSite(@RequestBody @Validated(value = Create.class) SiteDTO siteDTO) {
        return ResponseResult.ok(siteService.createNewSite(siteDTO));
    }


    /**
     * Retrieves a paginated list of sites based on the provided parameters.
     *
     * @param sitePage The pagination and filter parameters for querying sites.
     * @return A paginated list of site  wrapped in a {@link ResponseResult}.
     * @since 1.0.0
     */
    @PostMapping(value = "/pageSiteList")
    public ResponseResult<ListResult<SiteVO>> pageSiteList(SitePage sitePage) {
        return ResponseResult.ok(siteService.pageSiteList(sitePage));
    }
}
