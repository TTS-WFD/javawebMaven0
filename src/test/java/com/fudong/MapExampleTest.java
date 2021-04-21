package com.fudong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapExampleTest {

    MapExample mape;

    @BeforeEach
    public void up(){

        this.mape = new MapExample();

    }

    @Test
    public void test1(){
        mape.mapFirst();
    }

    @Test
    public  void test2(){mape.singleNumber();}

    @Test
    public void  test3(){
        try {
            mape.reflectExample();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void  test4(){mape.proxyExample();}

    @Test
    public void testAnnotationExample(){mape.annotationExample(mape.new Person("awng"));};

}

