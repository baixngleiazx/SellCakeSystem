package com.atguigu.springcloud.entities.adapter.impl;

import com.atguigu.springcloud.entities.adapter.IAdapterPlayAll;

public class AdapterMp5 implements IAdapterPlayAll {

    public void playMp4(String fileName) {

    }

    public void playMp5(String fileName) {
        System.out.println("播放Mp5「"+fileName+"」文件");
    }
}
