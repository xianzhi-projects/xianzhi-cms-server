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
     * 站点服务
     */
    private final SiteService siteService;

    /**
     * 创建一个新的站点
     *
     * @param siteDTO 站点信息入参
     * @return 站点ID
     * @since 1.0.0
     */
    @AuditLog
    @PostMapping(value = "/createNewSite")
    public ResponseResult<String> createNewSite(@RequestBody @Validated(value = Create.class) SiteDTO siteDTO) {
        return ResponseResult.ok(siteService.createNewSite(siteDTO));
    }


    /**
     * 查询站点列表
     *
     * @param sitePage 查询站点列表入参
     * @return 站点列表
     * @since 1.0.0
     */
    @PostMapping(value = "/pageSiteList")
    public ResponseResult<ListResult<SiteVO>> pageSiteList(@RequestBody SitePage sitePage) {
        return ResponseResult.ok(siteService.pageSiteList(sitePage));
    }
}
