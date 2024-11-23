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
 * 用户相关业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserBusiness {

    /**
     * 用户信息持久层
     */
    private final UserMapper userMapper;

    /**
     * 缓存处理
     */
    private final RedisProcessor redisProcessor;

    /**
     * 根据用户ID查询用户信息，如果用户不存在则抛出异常
     *
     * @param userId 用户ID
     * @return 用户信息
     * @since 1.0.0
     */
    public UserDO getUserByIdOrThrow(String userId) {
        return getUserById(userId).orElseThrow(() -> {
            log.error("根据用户ID查询用户信息为空,用户ID: {}", userId);
            return new BusinessException(UserCode.USER_NOT_EXIST);
        });
    }

    /**
     * 通过用户ID查询用户信息，首先检查缓存，如果找不到，则查询数据库。
     * 如果在到用数据库中找不户，它会在缓存中短时间存储一个空的UserDO
     * 以避免频繁的数据库查找。
     *
     * @param userId 用户ID
     * @return 用户信息
     * @since 1.0.0
     */
    public Optional<UserDO> getUserById(String userId) {
        if (!StringUtils.hasText(userId)) {
            log.error("根据用户ID查询用户信息失败,用户ID为空");
            throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
        }
        String cacheKey = String.format(UserCacheKeyConstant.USER_INFO_ID, userId);
        UserDO userDO = redisProcessor.vGet(cacheKey, UserDO.class);
        if (userDO == null) {
            Optional<UserDO> userOp = userMapper.selectUserById(userId);
            if (userOp.isPresent()) {
                userDO = userOp.get();
                redisProcessor.vSet(cacheKey, userDO);
            } else {
                userDO = new UserDO();
                redisProcessor.vSet(cacheKey, userDO, 10L, TimeUnit.SECONDS);
            }
        }
        return StringUtils.hasText(userDO.getId()) ? Optional.of(userDO) : Optional.empty();
    }
}
