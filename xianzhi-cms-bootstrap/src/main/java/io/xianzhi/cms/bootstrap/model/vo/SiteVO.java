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
 * View Object for site information response.
 * <p>
 * This class is used to encapsulate data for returning site-related information to the client.
 * </p>
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class SiteVO implements Serializable {


    /**
     * Site ID.
     *
     * @since 1.0.0
     */
    private String id;

    /**
     * Site name.
     *
     * @since 1.0.0
     */
    private String siteName;
    /**
     * Site description.
     *
     * @since 1.0.0
     */
    private String siteDesc;
    /**
     * Site logo.
     *
     * @since 1.0.0
     */
    private String siteLogo;
    /**
     * Site owner.
     *
     * @since 1.0.0
     */
    private UserVO siteOwner;
    /**
     * Site domain.
     *
     * @since 1.0.0
     */
    private String siteDomain;
    /**
     * Site favicon.
     *
     * @since 1.0.0
     */
    private String favicon;
    /**
     * Site SEO title.
     *
     * @since 1.0.0
     */
    private String siteSeoTitle;
    /**
     * Site SEO keywords.
     *
     * @since 1.0.0
     */
    private String siteSeoKeywords;
    /**
     * Site SEO description.
     *
     * @since 1.0.0
     */
    private String siteSeoDescription;

}
