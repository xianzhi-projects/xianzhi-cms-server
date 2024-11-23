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

package io.xianzhi.cms.bootstrap.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 站点信息出参
 * @author Max
 * @since 1.0.0
 */
@Data
public class SiteVO implements Serializable {


    /**
     * 站点ID
     *
     * @since 1.0.0
     */
    private String id;

    /**
     * 站点名称
     *
     * @since 1.0.0
     */
    private String siteName;
    /**
     * 站点描述
     *
     * @since 1.0.0
     */
    private String siteDesc;
    /**
     * 站点Logo
     *
     * @since 1.0.0
     */
    private String siteLogo;
    /**
     * 站点负责人
     *
     * @since 1.0.0
     */
    private UserVO owner;

    /**
     * 站点所属机构
     *
     * @since 1.0.0
     */
    private OrganizationVO organization;
    /**
     * 站点域名
     *
     * @since 1.0.0
     */
    private String siteDomain;
    /**
     * 站点 favicon.
     *
     * @since 1.0.0
     */
    private String favicon;
    /**
     * SEO标题
     *
     * @since 1.0.0
     */
    private String siteSeoTitle;
    /**
     * SEO关键字
     *
     * @since 1.0.0
     */
    private String siteSeoKeywords;
    /**
     * SEO描述
     *
     * @since 1.0.0
     */
    private String siteSeoDescription;

}
