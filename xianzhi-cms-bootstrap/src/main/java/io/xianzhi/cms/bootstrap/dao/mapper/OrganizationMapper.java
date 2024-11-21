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
import io.xianzhi.cms.bootstrap.dao.dataobj.OrganizationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * Mapper interface for accessing the "xz_organization" table.
 * <p>
 * This interface extends the {@link BaseMapper} and provides methods to perform CRUD operations
 * on the "xz_organization" table. The {@link OrganizationDO} entity represents the data model for this table.
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface OrganizationMapper extends BaseMapper<OrganizationDO> {

    /**
     * Retrieves an {@link OrganizationDO} by its ID.
     * <p>
     * This method checks the database for an organization with the specified ID. If found, it returns
     * the corresponding {@link OrganizationDO} wrapped in an {@link Optional}. If not found, it returns an empty {@link Optional}.
     *
     * @param organizationId The ID of the organization to retrieve.
     * @return An {@link Optional} containing the {@link OrganizationDO} if found, or an empty {@link Optional} if not.
     * @since 1.0.0
     */
    Optional<OrganizationDO> selectOrganizationById(@Param("organizationId") String organizationId);
}
