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
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * Mapper interface for the 'xz_user' table.
 * <p>
 * This interface extends the BaseMapper interface provided by MyBatis Plus to perform CRUD operations on the 'xz_user' table.
 * It allows for operations such as insert, update, delete, and query for user data.
 * The interface works with the UserDO (Data Object) class that represents the 'xz_user' table in the database.
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {


    /**
     * Fetch a user by their ID.
     * <p>
     * This method retrieves a `UserDO` entity from the database based on the provided `userId`. It returns an
     * `Optional<UserDO>` to handle cases where a user with the specified ID does not exist, avoiding potential
     * `NullPointerException` issues. If a user is found, the `Optional` will contain the `UserDO` entity, otherwise,
     * it will be empty.
     *
     * @param userId The ID of the user to be retrieved.
     * @return An `Optional<UserDO>` containing the user if found, or an empty `Optional` if no user with the given ID exists.
     * @since 1.0.0
     */
    Optional<UserDO> selectUserById(@Param("userId") String userId);
}
