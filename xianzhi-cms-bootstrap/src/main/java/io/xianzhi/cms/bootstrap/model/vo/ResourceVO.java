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

package io.xianzhi.cms.bootstrap.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 资源信息出参
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class ResourceVO implements Serializable {


    /**
     * 资源ID
     */
    private String id;

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
     * 子集资源
     */
    private List<ResourceVO> children;
}
