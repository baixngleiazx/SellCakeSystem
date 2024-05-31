package com.atguigu.springcloud.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class TaskThreadPools {
    @Autowired
    ThreadConfigurationProperties threadConfigurationProperties;

    @Bean
    public Executor  myTask(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(threadConfigurationProperties.getCoreThreads());
        threadPoolTaskExecutor.setMaxPoolSize(threadConfigurationProperties.getMaxThreads());
        //设置队列容量
        threadPoolTaskExecutor.setQueueCapacity(threadConfigurationProperties.getQueueThreads());
        //设置存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(threadConfigurationProperties.getThreadsTime());
        //设置线程前缀的名称
        threadPoolTaskExecutor.setThreadNamePrefix("mytask-");
        //当线程数量达到最大线程数的时候执行什么策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return threadPoolTaskExecutor;
    }

}
