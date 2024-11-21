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

package io.xianzhi.cms.bootstrap.constants;

/**
 * Constants for user-related cache keys.
 * <p>
 * This class contains static constants for cache keys used when storing or retrieving user data from the cache.
 * The constants help maintain consistency across the application, ensuring that the same cache keys are used
 * throughout the codebase, which is particularly useful for caching user information.
 *
 * @author Max
 * @since 1.0.0
 */
public interface UserCacheKeyConstant {

    /**
     * User information cache key by user id
     */
    String USER_INFO_ID = "cms:user:id:%s";
}
