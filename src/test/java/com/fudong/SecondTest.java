package com.fudong;

import com.fudong.dynamicAgent.DynamicProxyImpl;
import com.fudong.interfaces.AnimalInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fudong.Impl.Cat;

public class SecondTest {


    @BeforeEach
    public void up(){

    }

    @Test
    public void testDynamic(){
        AnimalInterface cat = new Cat();
        AnimalInterface proxy = (AnimalInterface) DynamicProxyImpl.getProxy(cat);
        proxy.call();
        proxy.eat();
        System.out.println("测试中……");
    }
}
