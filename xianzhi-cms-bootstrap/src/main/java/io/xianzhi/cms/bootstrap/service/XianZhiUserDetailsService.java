package io.xianzhi.cms.bootstrap.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户认证信息接口
 *
 * @author Max
 * @since 1.0.0
 */
public interface XianZhiUserDetailsService extends UserDetailsService {


    /**
     * 是否支持授权方式
     * @param grantType 授权方式
     * @return 响应信息
     */
    boolean support(String grantType);
}
