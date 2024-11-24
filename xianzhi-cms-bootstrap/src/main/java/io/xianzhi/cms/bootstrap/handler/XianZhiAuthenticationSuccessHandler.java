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

package io.xianzhi.cms.bootstrap.handler;

import io.xianzhi.cms.bootstrap.model.XianZhiUserDetails;
import io.xianzhi.cms.bootstrap.model.vo.TokenVO;
import io.xianzhi.cms.bootstrap.utils.JwtUtil;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.utils.JSONUtil;
import io.xianzhi.core.utils.ResponseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 自定义认证成功处理
 *
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class XianZhiAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    /**
     * JWT工具类
     */
    private final JwtUtil jwtUtil;


    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     *                       the authentication process.
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("认证成功处理，用户信息：{}", JSONUtil.toJSONString(authentication.getPrincipal()));
        // 构建token
        TokenVO token = buildTokenVO(authentication);
        ResponseUtils.responseUtf8(ResponseResult.ok(token), response);
    }


    private TokenVO buildTokenVO(Authentication authentication) {
        TokenVO tokenVO = new TokenVO();
        XianZhiUserDetails principal = (XianZhiUserDetails) authentication.getPrincipal();
        String accessToken = jwtUtil.generateToken(principal);
        String refreshToken = jwtUtil.generateRefreshToken(principal);
        tokenVO.setAccessToken(accessToken);
        tokenVO.setId(principal.getId());
        tokenVO.setRefreshToken(refreshToken);
        tokenVO.setAvatar(principal.getAvatar());
        tokenVO.setNickName(principal.getNickName());
        tokenVO.setDomainAccount(principal.getDomainAccount());
        tokenVO.setWorkNumber(principal.getWorkNumber());
        return tokenVO;
    }

//
//    /**
//     * 保存登录日志
//     *
//     * @param request        请求
//     * @param authentication 认证信息
//     */
//    private void saveLoginLog(HttpServletRequest request, Authentication authentication) {
//        LoginLogDO loginLogDO = new LoginLogDO();
//        logThreadPoolTaskExecutor.execute(() -> {
//            XianZhiUserDetails userDetails = (XianZhiUserDetails) authentication.getPrincipal();
//            loginLogDO.setUserId(userDetails.getId());
//            loginLogDO.setLoginMethod("password");
//
//            loginLogMapper.insert(loginLogDO);
//        });
//    }

}
