package com.secret.santa.configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ExecutorAsyncConfig {
    @Bean
    public Executor calculateGameExec() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //Core Pool size
        executor.setCorePoolSize(1);
        //Max Pool size
        executor.setMaxPoolSize(1);
        //Queue Size
        executor.setQueueCapacity(10);
        
        executor.setThreadNamePrefix("calculate-game-exec");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        
        return executor;
    }
}
