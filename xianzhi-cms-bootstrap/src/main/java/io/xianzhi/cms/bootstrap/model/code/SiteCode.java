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

package io.xianzhi.cms.bootstrap.model.code;

import io.xianzhi.core.result.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Max
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum SiteCode implements Result {
    /**
     * Site does not exist
     *
     * @since 1.0.0
     */
    SITE_NOT_EXIST("1000001", false, "cms:site.not.exist"),

    /**
     * Site name already exists
     *
     * @since 1.0.0
     */
    SITE_NAME_EXIST("1000002", false, "cms:site.name.exist"),

    /**
     * Site domain already exists
     *
     * @since 1.0.0
     */
    SITE_DOMAIN_EXIST("1000002", false, "cms:site.domain.exist"),

    /**
     * Site owner does not exist
     *
     * @since 1.0.0
     */
    SITE_OWNER_NOT_EXIST("1000001", false, "cms:site.owner.not.exist"),
    ;


    /**
     * The custom status code
     * This is a non-HTTP status code used for custom application responses.
     */
    private final String code;

    /**
     * Success flag
     * Indicates whether the operation was successful or not.
     */
    private final boolean success;

    /**
     * Custom message
     * Provides additional information about the operation.
     */
    private final String message;

    /**
     * Returns a custom status code (non-HTTP).
     *
     * @return The custom status code
     * @since 1.0.0
     */
    @Override
    public String code() {
        return this.code;
    }

    /**
     * Indicates whether the operation was successful or not.
     *
     * @return {@code true} if the operation was successful, {@code false} otherwise
     * @since 1.0.0
     */
    @Override
    public boolean success() {
        return this.success;
    }

    /**
     * Returns a custom message providing additional information about the operation.
     *
     * @return A custom message
     * @since 1.0.0
     */
    @Override
    public String message() {
        return this.message;
    }
}