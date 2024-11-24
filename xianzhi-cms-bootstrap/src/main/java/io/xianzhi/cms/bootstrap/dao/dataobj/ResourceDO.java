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
 * 资源信息实体
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName(value = "xz_resource")
@EqualsAndHashCode(callSuper = true)
public class ResourceDO extends BaseDO {


    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 资源类型
     */
    private String resourceType;
    /**
     * 资源描述
     */
    private String resourceDesc;
    /**
     * 资源路径
     */
    private String resourceKey;
    /**
     * 菜单排序
     */
    private Integer menuSort;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 菜单组件
     */
    private String menuComponent;
    /**
     * 是否显示
     */
    private Boolean showFlag;
    /**
     * 父级ID
     */
    private String parentId;
}
