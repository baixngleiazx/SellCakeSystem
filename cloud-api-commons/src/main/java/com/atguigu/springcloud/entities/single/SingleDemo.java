package com.atguigu.springcloud.entities.single;

public class SingleDemo {
    private static volatile SingleDemo singleDemo;
    private SingleDemo(){
    }
    //懒汉式的当
    public  static void getSingle(){
        if(singleDemo == null) {
            synchronized (singleDemo) {
                if (singleDemo == null) {
                    singleDemo = new SingleDemo();
                }
            }
        }
    }

}
