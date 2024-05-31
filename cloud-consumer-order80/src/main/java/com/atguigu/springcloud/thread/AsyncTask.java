package com.atguigu.springcloud.thread;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AsyncTask {
    @Async("myTask")
    public void doTask(int i){
        log.info("dotask"+i);
    }
}
