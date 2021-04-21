package com.fudong.dynamicAgent;

import com.fudong.Impl.Cat;
import com.fudong.interfaces.AnimalInterface;

public class DynamicImpl {
    public static void main(String[] args) {
        Cat cat = new Cat();
        AnimalInterface proxy = (AnimalInterface) DynamicProxyImpl.getProxy(cat);
        proxy.call();
        proxy.eat();
        System.out.println("测试中……");
    }

}
