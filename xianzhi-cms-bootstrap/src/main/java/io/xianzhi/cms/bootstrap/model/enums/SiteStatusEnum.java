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

package io.xianzhi.cms.bootstrap.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration representing the status of a site.
 * Each status includes a code and a description for better clarity and maintainability.
 *
 * @author Max
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum SiteStatusEnum {



    /**
     * The site is active.
     */
    ACTIVE("ACTIVE", "Active"),


    /**
     * The site is inactive.
     */
    INACTIVE("INACTIVE", "Inactive"),




    ;
    /**
     * The unique code representing the status.
     */
    private final String statusCode;

    /**
     * A description of what the status means.
     */
    private final String statusDesc;
}
