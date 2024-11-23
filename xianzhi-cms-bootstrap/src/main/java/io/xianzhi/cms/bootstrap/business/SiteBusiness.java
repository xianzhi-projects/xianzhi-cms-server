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
 * 站点业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SiteBusiness {

    /**
     * 站点信息持久层
     *
     * @since 1.0.0
     */
    private final SiteMapper siteMapper;

    /**
     * 缓存处理
     *
     * @since 1.0.0
     */
    private final RedisProcessor redisProcessor;

    /**
     * 根据站点ID查询站点信息，如果站点不存在则抛出异常
     *
     * @param siteId 站点ID
     * @return 站点信息
     * @since 1.0.0
     */
    public SiteDO getSiteByIdOrThrow(String siteId) {
        return getSiteById(siteId).orElseThrow(() -> {
            log.error("根据站点ID查询站点信息为空,站点ID: {}", siteId);
            return new BusinessException(SiteCode.SITE_NOT_EXIST);
        });
    }

    /**
     * 通过ID检索SiteDO，首先检查缓存，如果找不到，则查询数据库。
     * 如果在数据库中找不到该站点，它会在缓存中短时间存储一个空的SiteDO
     * 以避免频繁的数据库查找。
     *
     * @param siteId 站点ID
     * @return 站点信息
     * @since 1.0.0
     */
    public Optional<SiteDO> getSiteById(String siteId) {
        if (!StringUtils.hasText(siteId)) {
            log.error("根据站点ID查询站点信息失败,站点ID为空");
            throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
        }
        String cacheKey = String.format(SiteCacheKeyConstant.SITE_INFO_ID, siteId);
        SiteDO siteDO = redisProcessor.vGet(cacheKey, SiteDO.class);
        if (siteDO == null) {
            Optional<SiteDO> siteOp = siteMapper.selectSiteById(siteId);
            // 如果数据库存在站点信息
            if (siteOp.isPresent()) {
                siteDO = siteOp.get();
                redisProcessor.vSet(cacheKey, siteDO);
            } else {
                // 数据库中也不存在站点
                siteDO = new SiteDO();
                redisProcessor.vSet(cacheKey, siteDO, 10L, TimeUnit.SECONDS);
            }
        }
        return StringUtils.hasText(siteDO.getId()) ? Optional.of(siteDO) : Optional.empty();
    }
}
