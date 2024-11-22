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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

/**
 * Custom logout handler for the XianZhi system.
 * <p>
 * This class implements the {@link LogoutHandler} interface and is triggered when a user logs out.
 * It provides a custom way of handling logout events, such as clearing user sessions, logging the event,
 * or performing other necessary cleanup actions when a user logs out of the system.
 * <p>
 * The {@link #logout(HttpServletRequest, HttpServletResponse, Authentication)} method is called when
 * a user logs out, allowing for customized handling of the logout process. This could include things like
 * removing session data, logging the logout event, or redirecting the user to a specific page (such as a login page).
 *
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class XianZhiLogoutHandler implements LogoutHandler {
    /**
     * Causes a logout to be completed. The method must complete successfully.
     *
     * @param request        the HTTP request
     * @param response       the HTTP response
     * @param authentication the current principal details
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

    }
}
