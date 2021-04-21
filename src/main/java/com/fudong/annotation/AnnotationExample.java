package com.fudong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
@Target :元注解，用以修饰其他注解（Target可以定义该注解能够被应用于源码的哪些位置）
ElementType.METHOD ：用于方法
@Retention ：定义注解的生命周期
RetentionPolicy.RUNTIME：运行期
 */
@Target(ElementType.METHOD)//参数可以是数组
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationExample {
    int type() default  0;
    String level() default "info";
    String value() default "hello";
}
