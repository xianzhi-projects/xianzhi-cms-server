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

package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.cms.bootstrap.dao.dataobj.UserDO;
import io.xianzhi.cms.bootstrap.model.AuthUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * 用户信息持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {


    /**
     * 根据用户ID查询用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     * @since 1.0.0
     */
    Optional<UserDO> selectUserById(@Param("userId") String userId);


    /**
     * 根据工号/域账号/手机号码/邮箱地址查询用户信息
     *
     * @param account 工号/域账号/手机号码/邮箱地址
     * @return 用户信息
     */
    AuthUser loadAuthUserByAccount(@Param("account") String account);
}
