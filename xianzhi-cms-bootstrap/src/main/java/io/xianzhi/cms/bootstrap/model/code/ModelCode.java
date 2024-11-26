package io.xianzhi.cms.bootstrap.model.code;

import io.xianzhi.core.result.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 模型状态码
 *
 * @author Max
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ModelCode implements Result {


    /**
     * 模型不存在
     */
    MODEL_NOT_EXIST("1000000", false, "model.not.exist"),
    /**
     * 模型表名称已经存在
     */
    MODEL_TABLE_NAME_EXIST("1000001", false, "model.table.name.exist"),

    /**
     * 模型名称已经存在
     */
    MODEL_NAME_EXIST("1000002", false, "model.name.exist"),

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
