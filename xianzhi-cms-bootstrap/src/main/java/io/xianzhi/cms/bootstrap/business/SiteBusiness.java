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
import io.xianzhi.cms.bootstrap.constants.SiteCacheKeyConstant;
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteDO;
import io.xianzhi.cms.bootstrap.dao.mapper.SiteMapper;
import io.xianzhi.cms.bootstrap.model.code.SiteCode;
import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Site business processing class
 * Handles the business logic related to sites
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SiteBusiness {

    /**
     * Site data access object (DAO) mapper
     */
    private final SiteMapper siteMapper;

    /**
     * Redis processor for caching
     */
    private final RedisProcessor redisProcessor;

    /**
     * Retrieves a site by ID or throws an exception if not found
     *
     * @param siteId The site ID to retrieve
     * @return The site data object
     */
    public SiteDO getSiteByIdOrThrow(String siteId) {
        return getSiteById(siteId).orElseThrow(() -> {
            log.error("Site not found for ID: {}", siteId);
            return new BusinessException(SiteCode.SITE_NOT_EXIST);
        });
    }

    /**
     * Retrieves a SiteDO by its ID, first checking the cache and then querying the database if not found.
     * If the site is not found in the database, it stores an empty SiteDO in cache for a short time
     * to avoid frequent database lookups.
     *
     * @param siteId The ID of the site to retrieve.
     * @return An Optional containing the SiteDO if found, or an empty Optional if not.
     * @throws BusinessException if the site ID is null or empty.
     */
    public Optional<SiteDO> getSiteById(String siteId) {
        if (!StringUtils.hasText(siteId)) {
            log.error("Site ID is empty or null");
            throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
        }
        String cacheKey = String.format(SiteCacheKeyConstant.SITE_INFO_ID, siteId);
        SiteDO siteDO = redisProcessor.vGet(cacheKey, SiteDO.class);
        if (siteDO == null) {
            Optional<SiteDO> siteOp = siteMapper.selectSiteById(siteId);
            // If site is found in the database, cache it for future use
            if (siteOp.isPresent()) {
                siteDO = siteOp.get();
                redisProcessor.vSet(cacheKey, siteDO);
            } else {
                // If site is not found, store an empty SiteDO in cache for a short period
                siteDO = new SiteDO();
                redisProcessor.vSet(cacheKey, siteDO, 10L, TimeUnit.SECONDS);  // Cache empty SiteDO to avoid repetitive DB queries
            }
        }
        // Return the site if found, otherwise an empty Optional
        return StringUtils.hasText(siteDO.getId()) ? Optional.of(siteDO) : Optional.empty();
    }
}
