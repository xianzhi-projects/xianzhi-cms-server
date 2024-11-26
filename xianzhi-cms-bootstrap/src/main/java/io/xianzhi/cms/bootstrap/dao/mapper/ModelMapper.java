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
import io.xianzhi.cms.bootstrap.dao.dataobj.ModelDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * 模型信息持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface ModelMapper extends BaseMapper<ModelDO> {


    /**
     * 根据模型ID查询模型信息
     *
     * @param modelId 模型ID
     * @return 模型信息
     */
    Optional<ModelDO> selectModelById(@Param("modelId") String modelId);


    /**
     * 判断模型名称是否存在
     *
     * @param modelName 模型名称
     * @param modelId   模型ID
     * @return 是否存在
     * @since 1.0.0
     */
    boolean existsModelByModelNameAndIdNot(@Param("modelName") String modelName, @Param("modelId") String modelId);

    /**
     * 判断模型表名称是否存在
     *
     * @param tableName 表名称
     * @param modelId   模型ID
     * @return 是否存在
     * @since 1.0.0
     */
    boolean existsModelByTableNameAndIdNot(@Param("tableName") String tableName, @Param("modelId") String modelId);
}
