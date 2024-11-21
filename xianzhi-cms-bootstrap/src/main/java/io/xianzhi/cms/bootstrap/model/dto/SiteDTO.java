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

package io.xianzhi.cms.bootstrap.model.dto;

import io.xianzhi.core.validated.Create;
import io.xianzhi.core.validated.Update;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * Data Transfer Object for site input parameters.
 * <p>
 * This class is used to encapsulate data for site-related operations.
 * </p>
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class SiteDTO implements Serializable {

    /**
     * Unique identifier for the site.
     *
     * @since 1.0.0
     */
    @Length(max = 20, message = "cms:site.id.too.long", groups = {Update.class})
    @NotBlank(message = "cms:site.id.not.blank", groups = {Update.class})
    private String id;
    /**
     * Site name.
     *
     * @since 1.0.0
     */
    @Length(max = 64, message = "cms:site.name.too.long", groups = {Create.class, Update.class})
    @NotBlank(message = "cms:site.name.not.blank", groups = {Create.class, Update.class})
    private String siteName;
    /**
     * Site description.
     *
     * @since 1.0.0
     */
    @Length(max = 255, message = "cms:site.desc.too.long", groups = {Create.class, Update.class})
    private String siteDesc;
    /**
     * Site logo.
     *
     * @since 1.0.0
     */
    @Length(max = 255, message = "cms:site.logo.too.long", groups = {Create.class, Update.class})
    private String siteLogo;
    /**
     * Site owner.
     *
     * @since 1.0.0
     */
    @Length(max = 20, message = "cms:site.owner.too.long", groups = {Create.class, Update.class})
    @NotBlank(message = "cms:site.owner.not.blank", groups = {Create.class, Update.class})
    private String siteOwner;
    /**
     * Site domain.
     *
     * @since 1.0.0
     */
    @Length(max = 128, message = "cms:site.domain.too.long", groups = {Create.class, Update.class})
    @NotBlank(message = "cms:site.domain.not.blank", groups = {Create.class, Update.class})
    private String siteDomain;
    /**
     * Site favicon.
     *
     * @since 1.0.0
     */
    @Length(max = 255, message = "cms:site.favicon.too.long", groups = {Create.class, Update.class})
    private String favicon;

    /**
     * Site SEO title.
     *
     * @since 1.0.0
     */
    @Length(max = 255, message = "cms:site.seo.title.too.long", groups = {Create.class, Update.class})
    private String siteSeoTitle;
    /**
     * Site SEO keywords.
     *
     * @since 1.0.0
     */
    @Length(max = 255, message = "cms:site.seo.keywords.too.long", groups = {Create.class, Update.class})
    private String siteSeoKeywords;
    /**
     * Site SEO description.
     *
     * @since 1.0.0
     */
    @Length(max = 255, message = "cms:site.seo.description.too.long", groups = {Create.class, Update.class})
    private String siteSeoDescription;


}
