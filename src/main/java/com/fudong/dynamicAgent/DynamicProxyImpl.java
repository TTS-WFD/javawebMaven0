package com.fudong.dynamicAgent;

import java.lang.reflect.Proxy;

public class DynamicProxyImpl {
    public static Object getProxy(Object target){
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandlerImpl(target)
        );
        return  proxy;
    }
}
