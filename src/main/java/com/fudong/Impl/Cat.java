package com.fudong.Impl;

import com.fudong.interfaces.AnimalInterface;

public class Cat implements AnimalInterface {
    @Override
    public void call() {
        System.out.println("喵喵喵……");
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼……");
    }
}
