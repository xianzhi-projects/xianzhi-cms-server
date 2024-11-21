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

package io.xianzhi.cms.bootstrap.business;

import io.xianzhi.boot.redis.RedisProcessor;
import io.xianzhi.cms.bootstrap.constants.UserCacheKeyConstant;
import io.xianzhi.cms.bootstrap.dao.dataobj.UserDO;
import io.xianzhi.cms.bootstrap.dao.mapper.UserMapper;
import io.xianzhi.cms.bootstrap.model.code.UserCode;
import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Business logic layer for user-related operations.
 * <p>
 * This class serves as the business service for handling user-related operations, such as processing user data,
 * validating business rules, and coordinating various actions related to user management.
 * It is typically invoked by service classes or controllers to manage user-related business logic.
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserBusiness {

    /**
     * Mapper for user-related database operations.
     */
    private final UserMapper userMapper;

    /**
     * Redis processor for caching
     */
    private final RedisProcessor redisProcessor;

    /**
     * Retrieves a user by ID or throws an exception if not found
     *
     * @param userId The user ID to retrieve
     * @return The user data object
     * @since 1.0.0
     */
    public UserDO getUserByIdOrThrow(String userId) {
        return getUserById(userId).orElseThrow(() -> {
            log.error("User not found: {}", userId);
            return new BusinessException(UserCode.USER_NOT_EXIST);
        });
    }

    /**
     * Retrieves a UserDO by its ID, first checking the cache and then querying the database if not found.
     * If the user is not found in the database, it stores an empty UserDO in cache for a short time
     * to avoid frequent database lookups.
     *
     * @param userId The ID of the user to retrieve.
     * @return An Optional containing the UserDO if found, or an empty Optional if not.
     * @throws BusinessException if the user ID is null or empty.
     * @since 1.0.0
     */
    public Optional<UserDO> getUserById(String userId) {
        if (!StringUtils.hasText(userId)) {
            log.error("User ID is empty or null");
            throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
        }
        String cacheKey = String.format(UserCacheKeyConstant.USER_INFO_ID, userId);
        UserDO userDO = redisProcessor.vGet(cacheKey, UserDO.class);
        if (userDO == null) {
            Optional<UserDO> userOp = userMapper.selectUserById(userId);
            // If user is found in the database, cache it for future use
            if (userOp.isPresent()) {
                userDO = userOp.get();
                redisProcessor.vSet(cacheKey, userDO);
            } else {
                // If user is not found, store an empty UserDO in cache for a short period
                userDO = new UserDO();
                redisProcessor.vSet(cacheKey, userDO, 10L, TimeUnit.SECONDS);  // Cache empty SiteDO to avoid repetitive DB queries
            }
        }
        // Return the user if found, otherwise an empty Optional
        return StringUtils.hasText(userDO.getId()) ? Optional.of(userDO) : Optional.empty();
    }
}
