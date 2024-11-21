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

package io.xianzhi.cms.bootstrap.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import io.xianzhi.mybatis.plus.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Site Data Object (DO)
 * <p>
 * This class represents a Site entity in the application and maps to the 'xz_site' table in the database.
 * It contains fields that define the site-related information, along with metadata for persistence
 * and automatic data population for common fields (like created/updated timestamps).
 * The class extends from BaseDO, which provides common fields such as ID, created/modified by,
 * and timestamps.
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName(value = "xz_site")
@EqualsAndHashCode(callSuper = true)
public class SiteDO extends BaseDO {


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
    private String siteOwner;
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
