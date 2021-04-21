package com.fudong.dynamicAgent;

import com.fudong.annotation.AnnotationExample;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object targetObject;//代理中持有的目标类

    public InvocationHandlerImpl(Object targetObject){
        this.targetObject = targetObject;
    }

    /*
    proxy:代理目标的代理对象，他是真实的代理代理对象
    method:执行目标类的方法
    args:执行目标类的方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，执行前……");
        AnnotationExample annotation = method.getAnnotation(AnnotationExample.class);
        if (null != annotation){
            System.out.println("方法："+method.getName()+"有AnnotationExample注解，注解值为："+annotation.value());
        }else {
            System.out.println("方法："+method.getName()+"没有AnnotationExample注解");
        }
        Object result = method.invoke(targetObject,args);
        System.out.println("JDK动态代理，执行后……");
        return result;
    }
}
