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

package io.xianzhi.cms.bootstrap.filters;

import io.xianzhi.boot.redis.RedisProcessor;
import io.xianzhi.boot.security.code.SecurityCode;
import io.xianzhi.boot.security.exception.SecurityException;
import io.xianzhi.cms.bootstrap.constants.SecurityCacheConstant;
import io.xianzhi.cms.bootstrap.context.UserContextHolder;
import io.xianzhi.cms.bootstrap.model.XianZhiUserDetails;
import io.xianzhi.cms.bootstrap.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * JWT 认证过滤器
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    /**
     * Redis处理器
     */
    private final RedisProcessor redisProcessor;

    /**
     * JWT工具类
     */
    private final JwtUtil jwtUtil;


    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request     the request
     * @param response    the response
     * @param filterChain the {@code FilterChain} to use for invoking the next filter
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取Token
        String token = request.getHeader(SecurityCacheConstant.TOKEN_HEADER);
        if (!StringUtils.hasText(token) || !token.startsWith(SecurityCacheConstant.TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;

        }
        token = token.substring(7);
        if (jwtUtil.validateToken(token)){
            throw new SecurityException(SecurityCode.TOKEN_INVALID);
        }

        String userId = jwtUtil.getId(token);
        XianZhiUserDetails xianZhiUserDetails = redisProcessor.vGet(String.format(SecurityCacheConstant.AUTH_INFO, userId), XianZhiUserDetails.class);
        if (xianZhiUserDetails.getWorkNumber().equals("001")){
            xianZhiUserDetails.setAuthorities(new ArrayList<>(Collections.singleton(new SimpleGrantedAuthority("/**"))));
        }
        UserContextHolder.setContext(xianZhiUserDetails);
        // 认证成功
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(xianZhiUserDetails, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
