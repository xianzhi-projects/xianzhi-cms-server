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
 * Custom authentication success handler for the XianZhi system.
 * <p>
 * This class implements the {@link AuthenticationSuccessHandler} interface and is triggered
 * when authentication is successful (e.g., correct credentials). It provides a custom way of handling
 * successful authentication events, such as logging the success, redirecting the user to a specific page,
 * or performing other post-login actions.
 * <p>
 * The {@link #onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
 * method is called when authentication succeeds, allowing for customized handling of the success event.
 * This could include tracking successful logins, setting user-specific attributes, or redirecting the user
 * to a specific dashboard or homepage.
 *
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class XianZhiAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
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

    }
}
