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

package io.xianzhi.cms.bootstrap.model.page;

import io.xianzhi.core.base.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * Pagination query conditions for site information.
 * <p>
 * This class extends the custom {@link Page} class to include pagination details and query conditions.
 * </p>
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SitePage extends Page implements Serializable {

    /**
     * Filter for the site name.
     *
     * @since 1.0.0
     */
    @Length(max = 64, message = "cms.site.name.too.long")
    private String siteName;

    /**
     * Filter for the site owner.
     *
     * @since 1.0.0
     */
    @Length(max = 20, message = "cms.site.owner.too.long")
    private String siteOwner;

    /**
     * Filter for the site domain.
     *
     * @since 1.0.0
     */
    @Length(max = 64, message = "cms.site.domain.too.long")
    private String siteDomain;

    /**
     * Filter for the site status.
     *
     * @since 1.0.0
     */
    @Length(max = 32, message = "cms.site.status.too.long")
    private String siteStatus;

}
