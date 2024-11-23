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

package io.xianzhi.cms.bootstrap.service;

import io.xianzhi.cms.bootstrap.model.dto.SiteDTO;
import io.xianzhi.cms.bootstrap.model.page.SitePage;
import io.xianzhi.cms.bootstrap.model.vo.SiteVO;
import io.xianzhi.core.result.ListResult;

/**
 * 站点接口
 *
 * @author Max
 * @since 1.0.0
 */
public interface SiteService {
    /**
     * 创建一个新站点
     *
     * @param siteDTO 站点信息入参
     * @return 站点ID
     * @since 1.0.0
     */
    String createNewSite(SiteDTO siteDTO);

    /**
     * 查询站点列表
     *
     * @param sitePage 站点分页查询条件
     * @return 站点列表
     * @since 1.0.0
     */
    ListResult<SiteVO> pageSiteList(SitePage sitePage);
}
