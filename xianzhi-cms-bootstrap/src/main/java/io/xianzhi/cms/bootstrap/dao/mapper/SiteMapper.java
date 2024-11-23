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
 * 站点信息持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface SiteMapper extends BaseMapper<SiteDO> {

    /**
     * 根据站点ID查询站点信息
     *
     * @param siteId 站点ID
     * @return 站点信息
     * @since 1.0.0
     */
    Optional<SiteDO> selectSiteById(String siteId);

    /**
     * 判断站点名称是否存在
     *
     * @param siteName 站点名称
     * @param siteId   站点ID
     * @return 是否存在
     * @since 1.0.0
     */
    boolean existsSiteBySiteNameAndIdNot(@Param("siteName") String siteName, @Param("siteId") String siteId);

    /**
     * 检查站点域名是否存在
     *
     * @param siteDomain 站点域名
     * @param siteId     站点ID
     * @return 是否存在
     * @since 1.0.0
     */
    boolean existsSiteBySiteDomainAndIdNot(@Param("siteDomain") String siteDomain, @Param("siteId") String siteId);
}
