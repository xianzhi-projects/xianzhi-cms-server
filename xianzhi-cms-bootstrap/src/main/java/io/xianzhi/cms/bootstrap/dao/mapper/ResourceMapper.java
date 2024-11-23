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
import io.xianzhi.cms.bootstrap.dao.dataobj.ResourceDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * 资源信息持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface ResourceMapper extends BaseMapper<ResourceDO> {

    /**
     * 根据资源ID查询资源信息
     *
     * @param resourceId 资源ID
     * @return 资源信息
     * @since 1.0.0
     */
    Optional<ResourceDO> selectResourceById(@Param("resourceId") String resourceId);
}
