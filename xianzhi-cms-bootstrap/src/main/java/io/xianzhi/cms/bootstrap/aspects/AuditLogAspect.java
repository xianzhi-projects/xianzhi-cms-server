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

package io.xianzhi.cms.bootstrap.aspects;

import io.xianzhi.cms.bootstrap.annotations.AuditLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Aspect for handling audit log functionality. This class intercepts methods annotated
 * with @AuditLog and processes them to record audit logs based on the method execution.
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AuditLogAspect {

    /**
     * Defines the pointcut for methods annotated with @AuditLog.
     * This pointcut is triggered whenever a method with the @AuditLog annotation is called.
     *
     * @param auditLog The audit log annotation applied to the method.
     * @since 1.0.0
     */
    @Pointcut("@annotation(auditLog)")
    public void auditLogAnnotation(AuditLog auditLog) {
    }

    /**
     * Defines the around advice that is executed before and after the target method.
     * It handles audit log processing by wrapping the method execution and capturing logs.
     *
     * @param joinPoint The join point provides information about the method being intercepted.
     * @param auditLog  The audit log annotation containing the log details.
     * @return The result of the method execution.
     * @throws Throwable Any exception thrown during the method execution.
     * @since 1.0.0
     */
    @Around(value = "auditLogAnnotation(auditLog)", argNames = "joinPoint,auditLog")
    public Object around(ProceedingJoinPoint joinPoint, AuditLog auditLog) throws Throwable {
        return joinPoint.proceed();
    }
}