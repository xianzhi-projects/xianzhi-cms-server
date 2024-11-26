package io.xianzhi.cms.bootstrap.business;

import io.xianzhi.boot.redis.RedisProcessor;
import io.xianzhi.cms.bootstrap.constants.ColumnCacheKeyConstant;
import io.xianzhi.cms.bootstrap.dao.dataobj.ColumnDO;
import io.xianzhi.cms.bootstrap.dao.mapper.ColumnMapper;
import io.xianzhi.cms.bootstrap.model.code.ColumnCode;
import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 栏目业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ColumnBusiness {

    /**
     * 栏目Mapper
     */
    private final ColumnMapper columnMapper;

    /**
     * Redis处理器
     */
    private final RedisProcessor redisProcessor;

    /**
     * 根据栏目ID查询栏目信息,如果查询不到则抛出异常
     *
     * @param columnId 栏目ID
     * @return 栏目信息
     */
    public ColumnDO getColumnByIdOrThrow(String columnId) {
        return getColumnById(columnId).orElseThrow(() -> {
            log.error("根据栏目ID查询栏目信息失败，栏目ID：{}", columnId);
            return new BusinessException(ColumnCode.COLUMN_NOT_EXIST);
        });

    }

    /**
     * 根据栏目ID查询栏目信息
     *
     * @param columnId 栏目ID
     * @return 栏目信息
     */
    public Optional<ColumnDO> getColumnById(String columnId) {
        if (StringUtils.hasText(columnId)) {
            ColumnDO column = redisProcessor.vGet(String.format(ColumnCacheKeyConstant.COLUMN_CACHE_ID, columnId), ColumnDO.class);
            if (null == column) {
                Optional<ColumnDO> columnOp = columnMapper.selectByColumnId(columnId);
                if (columnOp.isPresent()) {
                    column = columnOp.get();
                    redisProcessor.vSet(String.format(ColumnCacheKeyConstant.COLUMN_CACHE_ID, columnId), column);
                } else {
                    column = new ColumnDO();
                    redisProcessor.vSet(String.format(ColumnCacheKeyConstant.COLUMN_CACHE_ID, columnId), column, 10L, TimeUnit.SECONDS);
                }
            }


            return StringUtils.hasText(column.getId()) ? Optional.of(column) : Optional.empty();
        }
        log.error("根据栏目ID查询栏目信息失败，栏目ID为空");
        throw new BusinessException(CommonCode.PARAMS_CHECK_FAIL);
    }


}
