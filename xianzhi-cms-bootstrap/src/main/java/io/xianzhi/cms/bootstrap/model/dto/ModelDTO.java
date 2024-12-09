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

package io.xianzhi.cms.bootstrap.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 模型入参
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class ModelDTO implements Serializable {

    /**
     * 模型ID
     */
    private String id;

    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 模型描述
     */
    private String modelDesc;
    /**
     * 模型表名
     */
    private String modelTableName;
    /**
     * 模型类型
     */
    private String modelType;
    /**
     * 是否启用标识
     */
    private Boolean enableFlag;
    /**
     * 模型排序
     */
    private Integer modelSort;

    /**
     * 公共模型标识
     */
    private Boolean commonFlag;
}
