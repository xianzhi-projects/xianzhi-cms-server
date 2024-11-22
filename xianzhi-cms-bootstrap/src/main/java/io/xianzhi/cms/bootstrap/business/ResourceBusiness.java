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
 * Handles the business logic related to system resources.
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ResourceBusiness {

    /**
     * Resource mapper
     */
    private final ResourceMapper resourceMapper;

    /**
     * Retrieves a specific resource based on its unique identifier from the database, or throws an exception if the resource is not found.
     *
     * @param resourceId the unique identifier of the resource to be retrieved
     * @return the resource entity ({@link ResourceDO})
     */
    public ResourceDO getResourceByIdOrThrow(String resourceId) {
        return getResourceById(resourceId).orElseThrow(() -> {
            log.error("Resource not found for ID: {}", resourceId);
            throw new BusinessException(ResourceCode.RESOURCE_NOT_EXIST);
        });
    }

    /**
     * Retrieves a specific resource based on its unique identifier from the database.
     *
     * @param resourceId the unique identifier of the resource to be retrieved
     * @return an {@link Optional} containing the resource entity ({@link ResourceDO})
     */
    public Optional<ResourceDO> getResourceById(String resourceId) {
        if (StringUtils.hasText(resourceId)) {
            return resourceMapper.selectResourceById(resourceId);
        }
        log.error("Resource ID is empty or null");
        throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
    }
}
