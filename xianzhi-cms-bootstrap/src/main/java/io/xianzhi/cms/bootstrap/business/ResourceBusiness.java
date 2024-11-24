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

import io.xianzhi.cms.bootstrap.dao.dataobj.ResourceDO;
import io.xianzhi.cms.bootstrap.dao.mapper.ResourceMapper;
import io.xianzhi.cms.bootstrap.model.code.ResourceCode;
import io.xianzhi.cms.bootstrap.model.vo.ResourceVO;
import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 资源相关业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ResourceBusiness {

    /**
     * 资源信息持久层
     */
    private final ResourceMapper resourceMapper;

    /**
     * 根据资源ID查询资源信息，如果资源不存在则抛出异常
     *
     * @param resourceId 资源ID
     * @return 资源实体
     * @since 1.0.0
     */
    public ResourceDO getResourceByIdOrThrow(String resourceId) {
        return getResourceById(resourceId).orElseThrow(() -> {
            log.error("根据资源ID查询资源信息为空,资源ID: {}", resourceId);
            return new BusinessException(ResourceCode.RESOURCE_NOT_EXIST);
        });
    }

    /**
     * 根据资源ID查询资源信息
     *
     * @param resourceId 资源ID
     * @return 资源信息
     * @since 1.0.0
     */
    public Optional<ResourceDO> getResourceById(String resourceId) {
        if (StringUtils.hasText(resourceId)) {
            return resourceMapper.selectResourceById(resourceId);
        }
        log.error("查询资源信息失败,资源ID为空");
        throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
    }

    /**
     * 转换未资源树出参
     *
     * @param resources 资源信息
     * @return 资源树出参
     * @since 1.0.0
     */
    public List<ResourceVO> convertResourceTree(List<ResourceDO> resources) {
        return resources.stream().filter(item -> !StringUtils.hasText(item.getParentId()) || "-1".equals(item.getParentId())).map(item -> convertResourceVO(item, resources)).sorted(Comparator.comparingInt(ResourceVO::getMenuSort)).collect(Collectors.toList());
    }

    /**
     * 转换子集树
     *
     * @param parentId  父ID
     * @param resources 资源信息
     * @return 子集树
     * @since 1.0.0
     */
    public List<ResourceVO> getChildren(String parentId, List<ResourceDO> resources) {
        return resources.stream().filter(item -> StringUtils.hasText(item.getParentId()) && item.getParentId().equals(parentId)).map(item -> convertResourceVO(item, resources)).sorted(Comparator.comparingInt(ResourceVO::getMenuSort)).collect(Collectors.toList());
    }

    /**
     * 转换资源出参
     *
     * @param item      资源信息
     * @param resources 资源信息
     * @return 资源出参
     * @since 1.0.0
     */
    private ResourceVO convertResourceVO(ResourceDO item, List<ResourceDO> resources) {
        ResourceVO resourceVO = new ResourceVO();
        resourceVO.setId(item.getId());
        resourceVO.setResourceName(item.getResourceName());
        resourceVO.setResourceKey(item.getResourceKey());
        resourceVO.setResourceDesc(item.getResourceDesc());
        resourceVO.setResourceType(item.getResourceType());
        resourceVO.setMenuComponent(item.getMenuComponent());
        resourceVO.setMenuIcon(item.getMenuIcon());
        resourceVO.setMenuSort(item.getMenuSort());
        resourceVO.setShowFlag(item.getShowFlag());
        resourceVO.setChildren(getChildren(item.getId(), resources));
        return resourceVO;
    }
}
