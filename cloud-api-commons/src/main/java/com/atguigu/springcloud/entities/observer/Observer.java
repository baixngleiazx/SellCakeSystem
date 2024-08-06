package com.atguigu.springcloud.entities.observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    private List<Pice> list = new ArrayList();
    private int age;
    public void setAge(int age){
        this.age = age;
        for (Pice pice : list){
           pice.subPice(age);
        }
    }
    public int getAge(){
        return age;
    }
    public void addList(Pice pice){
        list.add(pice);
    }

}
