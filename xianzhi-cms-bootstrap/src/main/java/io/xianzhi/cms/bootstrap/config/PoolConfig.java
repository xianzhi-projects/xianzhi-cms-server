package io.xianzhi.cms.bootstrap.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Configuration
public class PoolConfig {

    /**
     * 日志线程池
     *
     * @return ThreadPoolTaskExecutor
     */
    @Bean
    public ThreadPoolTaskExecutor logThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(2000);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("logThreadPool-");
        executor.setAllowCoreThreadTimeOut(true);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        log.info("初始化日志线程池成功,线程池参数,核心线程数:{},最大线程数:{},队列容量:{},线程存活时间:{}s", executor.getCorePoolSize(), executor.getMaxPoolSize(), executor.getQueueCapacity(), executor.getKeepAliveSeconds());
        return executor;
    }
}
