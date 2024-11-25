package io.xianzhi.cms.bootstrap.service;

import io.xianzhi.cms.bootstrap.model.dto.ModelDTO;
import io.xianzhi.cms.bootstrap.model.page.ModelPage;
import io.xianzhi.cms.bootstrap.model.vo.ModelVO;
import io.xianzhi.core.result.ListResult;

import java.util.List;

/**
 * 模型接口
 *
 * @author Max
 * @since 1.0.0
 */
public interface ModelService {
    /**
     * 新增模型
     *
     * @param modelDTO 模型信息
     * @return 模型ID
     * @since 1.0.0
     */
    String createModel(ModelDTO modelDTO);

    /**
     * 修改模型
     *
     * @param modelDTO 模型信息
     * @since 1.0.0
     */
    void updateModel(ModelDTO modelDTO);

    /**
     * 查询简单模型列表
     *
     * @return 简单模型列表
     * @since 1.0.0
     */
    List<ModelVO> getSimpleModelList();

    /**
     * 查询模型列表
     *
     * @param modelPage 模型分页信息
     * @return 模型列表
     * @since 1.0.0
     */
    ListResult<ModelVO> pageModelList(ModelPage modelPage);

    /**
     * 为模型分配站点，模型需要是私有模型
     *
     * @param modelId 模型ID
     * @param siteIds 站点ID
     * @return 响应信息
     * @since 1.0.0
     */
    void distributionModel(String modelId, List<String> siteIds);
}
