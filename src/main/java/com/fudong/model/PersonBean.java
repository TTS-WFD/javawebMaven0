package com.fudong.model;

import com.fudong.annotation.AnnotationExample;

import java.util.Objects;

public class PersonBean {

    private int age;

    private  String name;

    @AnnotationExample
    public void sayHello(String name){
        System.out.println("Hello，"+name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonBean that = (PersonBean) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
