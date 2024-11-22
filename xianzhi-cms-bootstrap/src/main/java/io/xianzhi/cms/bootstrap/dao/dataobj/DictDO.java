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

package io.xianzhi.cms.bootstrap.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import io.xianzhi.mybatis.plus.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity class for dict data.
 * <p>
 * This class maps to the `xz_dict` table in the database and represents
 * the persistent data structure for dicts. It extends the {@link BaseDO}
 * class to include common fields such as creation and modification timestamps.
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName(value = "xz_dict")
@EqualsAndHashCode(callSuper = true)
public class DictDO extends BaseDO {
}
