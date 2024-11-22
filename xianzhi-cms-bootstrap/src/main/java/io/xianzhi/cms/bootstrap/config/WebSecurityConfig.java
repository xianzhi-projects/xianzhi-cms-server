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
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
 * Web security configuration for the XianZhi application.
 * <p>
 * This class defines the security policies, authentication mechanisms, and access controls
 * for the application using Spring Security.
 * <p>
 * Key Features:
 * - Configures custom authentication success and failure handlers.
 * - Integrates a JWT authentication filter for token-based security.
 * - Implements stateless session management.
 * - Configures custom access denial and authentication entry point handlers.
 * - Provides a centralized security filter chain definition.
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
     * Security configuration properties.
     */
    private final SecurityProperties securityProperties;

    /**
     * Custom authentication success handler.
     */
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * Custom authentication failure handler.
     */
    private final AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * JWT authentication filter for token-based security.
     */
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * Handler for access denial scenarios.
     */
    private final AccessDeniedHandler accessDeniedHandler;

    /**
     * Entry point for unauthenticated access attempts.
     */
    private final AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * User authentication service for retrieving user details.
     */
    private final UserDetailsService userDetailsService;

    /**
     * Password encoder for hashing and validating passwords.
     */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Configures the security filter chain.
     *
     * @param http HTTP security configuration.
     * @return Configured {@link SecurityFilterChain}.
     * @throws Exception if an error occurs during configuration.
     * @since 1.0.0
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection globally.
                .authorizeHttpRequests(req -> req.requestMatchers(securityProperties.getPermitAllList().toArray(new String[0]))
                        .permitAll() // Allow requests to white-listed endpoints.
                        .anyRequest().authenticated()) // All other requests require authentication.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Use stateless session management.
                .exceptionHandling(config -> config.accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(authenticationEntryPoint)) // Configure custom exception handling.
                .addFilterBefore(jsonAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class) // Add custom authentication filter.
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Add JWT authentication filter.
                .logout(logout -> logout.logoutUrl("/logout")
                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())); // Configure logout behavior.

        return http.build();
    }

    /**
     * Creates a custom JSON-based authentication filter.
     *
     * @param authenticationManager Authentication manager for handling authentication requests.
     * @return Configured {@link JsonAuthenticationFilter}.
     * @since 1.0.0
     */
    public JsonAuthenticationFilter jsonAuthenticationFilter(AuthenticationManager authenticationManager) {
        JsonAuthenticationFilter jsonAuthenticationFilter = new JsonAuthenticationFilter(authenticationManager);
        jsonAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler); // Set success handler.
        jsonAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler); // Set failure handler.
        return jsonAuthenticationFilter;
    }

    /**
     * Configures the authentication manager.
     * <p>
     * This manager uses a DAO authentication provider with a custom {@link UserDetailsService}
     * and a {@link BCryptPasswordEncoder} for password encoding.
     *
     * @return Configured {@link AuthenticationManager}.
     * @since 1.0.0
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); // Set user details service.
        provider.setPasswordEncoder(bCryptPasswordEncoder); // Set password encoder.
        return new ProviderManager(provider);
    }
}
