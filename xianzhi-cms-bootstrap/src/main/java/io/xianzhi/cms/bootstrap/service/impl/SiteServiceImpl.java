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
 * 站点接口实现
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
     * 创建一个新站点
     *
     * @param siteDTO 站点信息入参
     * @return 站点ID
     * @since 1.0.0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createNewSite(SiteDTO siteDTO) {
        SiteDO site = checkedSiteDTO(siteDTO);
        siteMapper.insert(site);
        // 为站点创建一个OSS存储桶
        ossProcessor.createBucket("cms:" + site.getId());
        log.info("create site success,site id:{},site bucketName:{}", site.getId(), "cms:" + site.getId());
        return site.getId();
    }

    /**
     * 查询站点列表
     *
     * @param sitePage 站点分页查询条件
     * @return 站点列表
     * @since 1.0.0
     */
    @Override
    public ListResult<SiteVO> pageSiteList(SitePage sitePage) {

        return null;
    }

    /**
     * 检查站点信息入参
     *
     * @param siteDTO 站点信息入参
     * @return 站点信息
     */
    private SiteDO checkedSiteDTO(SiteDTO siteDTO) {
        SiteDO site;
        if (StringUtils.hasText(siteDTO.getId())) {
            site = siteBusiness.getSiteByIdOrThrow(siteDTO.getId());
        } else {
            site = new SiteDO();
        }
        // 判断站点名称是否存在
        if (siteMapper.existsSiteBySiteNameAndIdNot(siteDTO.getSiteName(), siteDTO.getId())) {
            log.error("Site name already exists: {},Site id: {}", siteDTO.getSiteName(), site.getId());
            throw new BusinessException(SiteCode.SITE_NAME_EXIST);
        }
        // 判断站点域名是否存在
        if (siteMapper.existsSiteBySiteDomainAndIdNot(siteDTO.getSiteDomain(), siteDTO.getId())) {
            log.error("Site domain already exists: {},Site id: {}", siteDTO.getSiteDomain(), site.getId());
            throw new BusinessException(SiteCode.SITE_DOMAIN_EXIST);
        }
        // 检查站点所有者是否存在
        userBusiness.getUserById(siteDTO.getSiteOwner()).orElseThrow(() -> {
            log.error("Site owner does not exist: {}", siteDTO.getSiteOwner());
            return new BusinessException(SiteCode.SITE_OWNER_NOT_EXIST);
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
