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
import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

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
     */
    public Optional<ResourceDO> getResourceById(String resourceId) {
        if (StringUtils.hasText(resourceId)) {
            return resourceMapper.selectResourceById(resourceId);
        }
        log.error("查询资源信息失败,资源ID为空");
        throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
    }
}
