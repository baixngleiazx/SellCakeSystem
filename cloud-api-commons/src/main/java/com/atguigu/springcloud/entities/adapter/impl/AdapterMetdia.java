package com.atguigu.springcloud.entities.adapter.impl;

import com.atguigu.springcloud.entities.adapter.IAdapterMetdia;
import com.atguigu.springcloud.entities.adapter.IAdapterPlayAll;

public class AdapterMetdia implements IAdapterMetdia {

    IAdapterPlayAll iAdapterPlayAll;

    public AdapterMetdia(String fileName) {
        if ("mp4".equals(fileName)) {
            iAdapterPlayAll = new AdapterMp4();
        }
        if ("mp5".equals(fileName)) {
            iAdapterPlayAll = new AdapterMp5();
        }
    }

    public void play(String aituoType, String fileName) {
        if (aituoType.equals("mp4") ) {
            iAdapterPlayAll.playMp4(fileName);
        }
        if ("mp5".equals(fileName)) {
            iAdapterPlayAll.playMp5(fileName);
        }
        System.out.println("mp3「"+fileName+"」文件名称");
    }
}
