package com.atguigu.springcloud.thread;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 线程池属性配置类
 */
@ConfigurationProperties("task.pool")
public class ThreadConfigurationProperties {
    private int maxThreads;
    private int coreThreads;
    private int queueThreads;
    private int threadsTime;

    public int getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public int getCoreThreads() {
        return coreThreads;
    }

    public void setCoreThreads(int coreThreads) {
        this.coreThreads = coreThreads;
    }

    public int getQueueThreads() {
        return queueThreads;
    }

    public void setQueueThreads(int queueThreads) {
        this.queueThreads = queueThreads;
    }

    public int getThreadsTime() {
        return threadsTime;
    }

    public void setThreadsTime(int threadsTime) {
        this.threadsTime = threadsTime;
    }
}
