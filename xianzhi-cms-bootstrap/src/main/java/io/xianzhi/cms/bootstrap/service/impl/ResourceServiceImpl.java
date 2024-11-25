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

import io.xianzhi.cms.bootstrap.business.ResourceBusiness;
import io.xianzhi.cms.bootstrap.context.UserContextHolder;
import io.xianzhi.cms.bootstrap.dao.dataobj.ResourceDO;
import io.xianzhi.cms.bootstrap.dao.mapper.ResourceMapper;
import io.xianzhi.cms.bootstrap.model.dto.ResourceDTO;
import io.xianzhi.cms.bootstrap.model.vo.ResourceVO;
import io.xianzhi.cms.bootstrap.service.ResourceService;
import io.xianzhi.cms.bootstrap.utils.SiteUtil;
import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.context.ContextHolder;
import io.xianzhi.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Resource interface implementation
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    /**
     * 资源业务类
     */
    private final ResourceBusiness resourceBusiness;

    /**
     * 资源信息持久层
     */
    private final ResourceMapper resourceMapper;


    /**
     * 新增资源信息
     *
     * @param resourceDTO 资源信息入参
     * @return 资源ID
     * @since 1.0.0
     */
    @Override
    public String createResource(ResourceDTO resourceDTO) {
        ResourceDO resource = checkedResourceDTO(resourceDTO);
        resourceMapper.insert(resource);
        return resource.getId();
    }

    /**
     * 修改资源
     *
     * @param resourceDTO 资源信息入参
     * @since 1.0.0
     */
    @Override
    public void updateResource(ResourceDTO resourceDTO) {
        ResourceDO resource = checkedResourceDTO(resourceDTO);
        resourceMapper.updateById(resource);

    }

    /**
     * 查询系统资源树
     *
     * @return 资源树信息
     * @since 1.0.0
     */
    @Override
    public List<ResourceVO> tree() {
        return List.of();
    }

    /**
     * 获取当前用户的资源信息
     *
     * @return 当前用户资源信息
     * @since 1.0.0
     */
    @Override
    public List<ResourceVO> getCurrentUserResource() {
        List<ResourceDO> resources;
        if (UserContextHolder.superAdmin()) {
            resources = resourceMapper.selectAdminResource();
        } else {
            String siteId = SiteUtil.getCurrentSiteId();
            String userId = ContextHolder.getId();

            resources = new ArrayList<>();
        }
        if (ObjectUtils.isEmpty(resources)) {
            throw new BusinessException(CommonCode.UNAUTHORIZED);
        }
        return resourceBusiness.convertResourceTree(resources);
    }

    /**
     * 检查资源信息入参
     *
     * @param resourceDTO 资源信息入参
     * @return 资源信息
     * @since 1.0.0
     */
    private ResourceDO checkedResourceDTO(ResourceDTO resourceDTO) {
        ResourceDO resource;
        if (StringUtils.hasText(resourceDTO.getId())) {
            resource = resourceBusiness.getResourceByIdOrThrow(resourceDTO.getId());
        } else {
            resource = new ResourceDO();
        }
        return resource;
    }
}
