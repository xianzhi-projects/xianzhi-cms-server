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
import io.xianzhi.cms.bootstrap.dao.dataobj.AdvertisementDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper interface for advertisement data operations.
 *
 * This interface extends the {@link BaseMapper} to provide basic CRUD
 * functionality for the {@link AdvertisementDO} entity. It acts as a
 * bridge between the application and the database, enabling operations
 * such as querying, inserting, updating, and deleting advertisements.
 *
 * Annotations:
 * - {@link Mapper}: Marks this interface as a MyBatis Mapper for dependency injection.
 *
 * @see AdvertisementDO
 * @see BaseMapper
 * @since 1.0.0
 */
@Mapper
public interface AdvertisementMapper extends BaseMapper<AdvertisementDO> {
}
