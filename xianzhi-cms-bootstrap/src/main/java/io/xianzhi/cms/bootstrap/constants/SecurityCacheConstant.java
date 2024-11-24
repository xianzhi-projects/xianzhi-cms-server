package io.xianzhi.cms.bootstrap.constants;

/**
 * 安全相关缓存key
 *
 * @author Max
 * @since 1.0.0
 */
public interface SecurityCacheConstant {

    /**
     * Token前缀
     */
    String TOKEN_PREFIX = "Bearer ";

    /**
     * Token 请求头
     */
    String TOKEN_HEADER = "Authorization";

    /**
     * Token缓存
     */
    String AUTH_INFO = "auth:user:%s";


}
