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

import io.xianzhi.cms.bootstrap.model.dto.ResourceDTO;
import io.xianzhi.cms.bootstrap.model.vo.ResourceVO;
import io.xianzhi.cms.bootstrap.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Resource interface implementation
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {



    /**
     * Create a new resource.
     *
     * @param resourceDTO resource data
     * @return resource ID
     */
    @Override
    public String createResource(ResourceDTO resourceDTO) {
        return "";
    }

    /**
     * Update the resource.
     *
     * @param resourceDTO resource data
     */
    @Override
    public void updateResource(ResourceDTO resourceDTO) {

    }

    /**
     * Retrieves all system resource information and converts it into a tree structure.
     *
     * @return resources structured as a tree.
     * @since 1.0.0
     */
    @Override
    public List<ResourceVO> tree() {
        return List.of();
    }
}
