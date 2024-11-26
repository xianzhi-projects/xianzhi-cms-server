package io.xianzhi.cms.bootstrap.service;

import io.xianzhi.cms.bootstrap.model.dto.FieldDTO;
import io.xianzhi.cms.bootstrap.model.vo.FieldVO;

import java.util.List;

/**
 * 字段接口
 * @author Max
 * @since 1.0.0
 */
public interface FieldService {

    /**
     * 模型ID获取字段信息
     *
     * @param modelId 模型ID
     * @return 字段信息
     * @since 1.0.0
     */
    List<FieldVO> getFieldsByModelId(String modelId);


    /**
     * 保存字段
     *
     * @param modelId 模型ID
     * @param fields  字段信息
     * @since 1.0.0
     */
    void saveField(String modelId, List<FieldDTO> fields);
}
