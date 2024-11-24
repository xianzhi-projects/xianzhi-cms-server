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

package io.xianzhi.cms.bootstrap.config;

import io.xianzhi.boot.security.properties.SecurityProperties;
import io.xianzhi.cms.bootstrap.filters.JsonAuthenticationFilter;
import io.xianzhi.cms.bootstrap.filters.JwtAuthenticationFilter;
import io.xianzhi.cms.bootstrap.provider.XianZhiDaoAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 应用安全配置类
 *
 * @author Max
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig {


    /**
     * 安全相关配置
     */
    private final SecurityProperties securityProperties;

    /**
     * 认证成功处理
     */
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * 认证失败处理
     */
    private final AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * JWT认证过滤器
     */
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * 权限不足处理
     */
    private final AccessDeniedHandler accessDeniedHandler;

    /**
     * 为授权处理
     */
    private final AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 用户认证接口
     */
    private final UserDetailsService userDetailsService;

    /**
     * 密码加密器
     */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 配置安全过滤器链
     *
     * @param http {@link HttpSecurity}实例
     * @return 安全过滤器链
     * @since 1.0.0
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection globally.
                .authorizeHttpRequests(req -> req.requestMatchers(securityProperties.getPermitAllList().toArray(new String[0]))
                        .permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(config -> config.accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(authenticationEntryPoint))
                .addFilterBefore(jsonAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout.logoutUrl("/logout")
                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext()));

        return http.build();
    }

    /**
     * 创建JSON认证过滤器
     *
     * @param authenticationManager 认证管理器
     * @return JSON 认证过滤器
     * @since 1.0.0
     */
    public JsonAuthenticationFilter jsonAuthenticationFilter(AuthenticationManager authenticationManager) {
        JsonAuthenticationFilter jsonAuthenticationFilter = new JsonAuthenticationFilter(authenticationManager);
        jsonAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        jsonAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        return jsonAuthenticationFilter;
    }

    /**
     * 配置认证管理器
     *
     * @return Configured 认证管理器
     * @since 1.0.0
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        XianZhiDaoAuthenticationProvider provider = new XianZhiDaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(provider);
    }
}
