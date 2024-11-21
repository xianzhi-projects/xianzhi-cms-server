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
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * Site Mapper Interface
 * <p>
 * This interface serves as a MyBatis Mapper for the `SiteDO` entity, allowing the interaction
 * between the application and the database. It extends from `BaseMapper<SiteDO>`, which provides
 * common methods for basic CRUD operations (Create, Read, Update, Delete) without needing to
 * manually define SQL statements.
 * <p>
 * The `@Mapper` annotation marks this interface as a MyBatis Mapper, allowing it to be
 * recognized and injected into Spring components for database operations.
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface SiteMapper extends BaseMapper<SiteDO> {

    /**
     * Select a site by its ID.
     * <p>
     * This method retrieves a `SiteDO` object from the database based on the provided `siteId`.
     * It returns an `Optional<SiteDO>`, which allows handling cases where the site might not
     * be found, avoiding potential `NullPointerException` by explicitly checking for presence or absence.
     * <p>
     * The method uses the `siteId` to query the `xz_site` table and returns the corresponding `SiteDO`
     * entity if found. If no site with the given ID exists, it will return an empty `Optional`.
     *
     * @param siteId The unique identifier of the site to be retrieved.
     * @return An `Optional<SiteDO>` containing the site data if found, otherwise an empty Optional.
     * @since 1.0.0
     */
    Optional<SiteDO> selectSiteById(String siteId);

    /**
     * Checks if a site with the given name exists, excluding the site with the specified ID.
     * This is useful for checking the uniqueness of a site name while ignoring the site with a particular ID.
     *
     * @param siteName The name of the site to check for.
     * @param siteId   The ID of the site to exclude from the check.
     * @return true if a site with the given name exists and has a different ID, false otherwise.
     * @since 1.0.0
     */
    boolean existsSiteBySiteNameAndIdNot(@Param("siteName") String siteName, @Param("siteId") String siteId);

    /**
     * Checks if a site with the given domain exists, excluding the site with the specified ID.
     * This is useful for checking the uniqueness of a site domain while ignoring the site with a particular ID.
     *
     * @param siteDomain The domain of the site to check for.
     * @param siteId     The ID of the site to exclude from the check.
     * @return true if a site with the given domain exists and has a different ID, false otherwise.
     * @since 1.0.0
     */
    boolean existsSiteBySiteDomainAndIdNot(@Param("siteDomain") String siteDomain, @Param("siteId") String siteId);
}
