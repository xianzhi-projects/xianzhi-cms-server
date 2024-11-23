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
 * 审计日志切面
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
     * 定义切点，匹配所有被{@link AuditLog}注解标记的方法
     *
     * @param auditLog 审计日志注解
     * @since 1.0.0
     */
    @Pointcut("@annotation(auditLog)")
    public void auditLogAnnotation(AuditLog auditLog) {
    }

    /**
     * 定义环绕通知，记录审计日志
     *
     * @param joinPoint 当前连接点
     * @param auditLog  审计日志.
     * @return 方法执行结果
     * @throws Throwable 如果执行方法报错则直接抛出对应异常.
     * @since 1.0.0
     */
    @Around(value = "auditLogAnnotation(auditLog)", argNames = "joinPoint,auditLog")
    public Object around(ProceedingJoinPoint joinPoint, AuditLog auditLog) throws Throwable {
        return joinPoint.proceed();
    }
}