package com.atguigu.springcloud.entities.adapter.impl;

import com.atguigu.springcloud.entities.adapter.IAdapterPlayAll;

public class AdapterMp4 implements IAdapterPlayAll {

    public void playMp4(String fileName) {
        System.out.println("播放Mp4「"+fileName+"」文件");
    }

    public void playMp5(String fileName) {

    }
}
