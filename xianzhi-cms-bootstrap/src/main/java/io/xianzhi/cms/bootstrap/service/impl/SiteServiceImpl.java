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

package io.xianzhi.cms.bootstrap.service.impl;

import io.xianzhi.boot.oss.OssProcessor;
import io.xianzhi.cms.bootstrap.business.SiteBusiness;
import io.xianzhi.cms.bootstrap.business.UserBusiness;
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteDO;
import io.xianzhi.cms.bootstrap.dao.mapper.SiteMapper;
import io.xianzhi.cms.bootstrap.model.code.SiteCode;
import io.xianzhi.cms.bootstrap.model.dto.SiteDTO;
import io.xianzhi.cms.bootstrap.model.page.SitePage;
import io.xianzhi.cms.bootstrap.model.vo.SiteVO;
import io.xianzhi.cms.bootstrap.service.SiteService;
import io.xianzhi.core.exception.BusinessException;
import io.xianzhi.core.result.ListResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


/**
 * Implementation of the site service interface.
 * Handles business logic for site-related operations.
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService {
    /**
     * Site business processing class
     */
    private final SiteBusiness siteBusiness;

    /**
     * Site data access mapper
     */
    private final SiteMapper siteMapper;

    /**
     * User business processing class
     */
    private final UserBusiness userBusiness;

    /**
     * Oss processor for file storage
     */
    private final OssProcessor ossProcessor;

    /**
     * Creates a new site.
     *
     * @param siteDTO The site data to be created.
     * @return Site id
     * @since 1.0.0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createNewSite(SiteDTO siteDTO) {
        SiteDO site = checkedSiteDTO(siteDTO);
        siteMapper.insert(site);
        // Create a bucket for the site in the OSS
        ossProcessor.createBucket("cms:" + site.getId());
        log.info("create site success,site id:{},site bucketName:{}", site.getId(), "cms:" + site.getId());
        return site.getId();
    }

    /**
     * Retrieves a paginated list of sites based on the provided parameters.
     *
     * @param sitePage The pagination and filter parameters for querying sites.
     * @return A paginated list of site
     * @since 1.0.0
     */
    @Override
    public ListResult<SiteVO> pageSiteList(SitePage sitePage) {

        return null;
    }

    /**
     * Validates and prepares a SiteDO object from the given SiteDTO.
     * - If the site ID is provided, it retrieves the existing site by ID.
     * - Checks if the site name and domain already exist, throwing exceptions if they do.
     * - Verifies that the site owner exists.
     * Copies properties from the SiteDTO to the SiteDO, excluding the 'id' field.
     *
     * @param siteDTO The site data transfer object to validate and convert.
     * @return A SiteDO object populated with data from the SiteDTO.
     * @throws BusinessException if any of the validation checks fail (e.g., site name or domain already exists, site owner does not exist).
     * @since 1.0.0
     */
    private SiteDO checkedSiteDTO(SiteDTO siteDTO) {
        SiteDO site;
        if (StringUtils.hasText(siteDTO.getId())) {
            site = siteBusiness.getSiteByIdOrThrow(siteDTO.getId());
        } else {
            site = new SiteDO();
        }
        // Check if the site name already exists
        if (siteMapper.existsSiteBySiteNameAndIdNot(siteDTO.getSiteName(), siteDTO.getId())) {
            log.error("Site name already exists: {},Site id: {}", siteDTO.getSiteName(), site.getId());
            throw new BusinessException(SiteCode.SITE_NAME_EXIST);
        }
        // Check if the site domain already exists
        if (siteMapper.existsSiteBySiteDomainAndIdNot(siteDTO.getSiteDomain(), siteDTO.getId())) {
            log.error("Site domain already exists: {},Site id: {}", siteDTO.getSiteDomain(), site.getId());
            throw new BusinessException(SiteCode.SITE_DOMAIN_EXIST);
        }
        // Check if the site owner exists
        userBusiness.getUserById(siteDTO.getSiteOwner()).orElseThrow(() -> {
            log.error("Site owner does not exist: {}", siteDTO.getSiteOwner());
            throw new BusinessException(SiteCode.SITE_OWNER_NOT_EXIST);
        });
        site.setSiteLogo(siteDTO.getSiteLogo());
        site.setSiteName(siteDTO.getSiteName());
        site.setSiteDomain(siteDTO.getSiteDomain());
        site.setSiteDesc(siteDTO.getSiteDesc());
        site.setSiteOwner(siteDTO.getSiteOwner());
        site.setSiteDesc(siteDTO.getSiteDesc());
        site.setFavicon(siteDTO.getFavicon());
        site.setSiteSeoDescription(siteDTO.getSiteSeoDescription());
        site.setSiteSeoTitle(siteDTO.getSiteSeoTitle());
        site.setSiteSeoKeywords(siteDTO.getSiteSeoKeywords());
        return site;
    }


}
