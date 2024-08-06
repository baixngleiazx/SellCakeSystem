package com.atguigu.springcloud.entities.observer;

public class ObserverMain {
    public static void main(String[] args) {
        Observer observer = new Observer();
        new Age(observer);
        new Age(observer);
        observer.setAge(8);
    }
}
