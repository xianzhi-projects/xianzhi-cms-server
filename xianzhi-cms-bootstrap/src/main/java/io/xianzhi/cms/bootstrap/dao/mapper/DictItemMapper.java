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
import io.xianzhi.cms.bootstrap.dao.dataobj.DictItemDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper interface for dictionary item operations.
 *
 * This interface extends {@link BaseMapper} to provide CRUD operations for
 * {@link DictItemDO} entities. It facilitates database interactions for managing
 * dictionary items, such as querying, inserting, updating, and deleting records.
 *
 * Annotations:
 * - {@link Mapper}: Marks this interface as a MyBatis Mapper for use with dependency injection.
 *
 * @see DictItemDO
 * @see BaseMapper
 * @since 1.0.0
 */
@Mapper
public interface DictItemMapper extends BaseMapper<DictItemDO> {
}
