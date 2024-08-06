package com.atguigu.springcloud.entities.observer;

public abstract class Pice {
    protected int pice=1000;
    public Observer observer;
    public abstract void subPice(int age);

}
