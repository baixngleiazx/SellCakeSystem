package com.atguigu.springcloud.entities.observer;

public class Age extends Pice {

    public Age(Observer observer) {
        this.observer = observer;
        observer.addList(this);
    }

    public void subPice(int age) {
        System.out.println(this.pice-age);
    }
}
