package com.atguigu.springcloud.thread;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@Component
@Slf4j
public class AsyncTask {
    @Async("myTask")
    public void doTask(int i){
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("2","2");

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(null,null);

        List<String>  list = new ArrayList<>();
        list.add("233");
//        log.info("dotask"+i);
    }


    public static void main(String[] args) {
        AsyncTask asyncTask = new AsyncTask();
        asyncTask.doTask(9);
    }
}
