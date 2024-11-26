package io.xianzhi.cms.bootstrap.model.code;

import io.xianzhi.core.result.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 栏目响应状态码
 *
 * @author Max
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ColumnCode implements Result {
    /**
     * 栏目不存在
     */
    COLUMN_NOT_EXIST("1000000", false, "column.not.exist"),

    ;
    /**
     * 自定义响应状态码
     */
    private final String code;

    /**
     * 是否操作成功
     */
    private final boolean success;

    /**
     * 自定义提示信息
     */
    private final String message;

    /**
     * 返回自定义状态码
     *
     * @return 自定义状态码
     * @since 1.0.0
     */
    @Override
    public String code() {
        return this.code;
    }

    /**
     * 表示操作是否成功
     *
     * @return {@code true} 表示成功, {@code false} 操作失败
     * @since 1.0.0
     */
    @Override
    public boolean success() {
        return this.success;
    }

    /**
     * 返回自定操作提示信息
     *
     * @return 自定义提示信息
     * @since 1.0.0
     */
    @Override
    public String message() {
        return this.message;
    }
}
