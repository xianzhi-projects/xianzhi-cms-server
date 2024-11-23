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
 * 站点信息实体
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName(value = "xz_site")
@EqualsAndHashCode(callSuper = true)
public class SiteDO extends BaseDO {


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
     * 站点 logo.
     *
     * @since 1.0.0
     */
    private String siteLogo;
    /**
     * 站点负责人
     *
     * @since 1.0.0
     */
    private String siteOwner;
    /**
     *组织机构ID
     *
     * @since 1.0.0
     */
    private String organizationId;
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
     * 站点 SEO 标题.
     *
     * @since 1.0.0
     */
    private String siteSeoTitle;
    /**
     * 站点 SEO 关键字.
     *
     * @since 1.0.0
     */
    private String siteSeoKeywords;
    /**
     * 站点 SEO 描述.
     *
     * @since 1.0.0
     */
    private String siteSeoDescription;

}
