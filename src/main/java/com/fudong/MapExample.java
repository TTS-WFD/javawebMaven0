package com.fudong;

import com.fudong.annotation.AnnotationExample;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapExample {

    class Pair<T>{
        private T first;
        private T last;
        public Pair(T first,T last){
            this.first = first;
            this.last = last;
        }

    }

    class IntPair extends Pair<Integer>{

        public IntPair(Integer first, Integer last) {
            super(first, last);
        }
    }

    class Person{
        private String name;

        public Person(String name){
            this.name = name;
        }
        @AnnotationExample
        void morning(String name){};
    }

    interface PersonInterface{
        @AnnotationExample
        void morning(String name);

        void say(String name);
    }

    public static int add(Pair<Number> p){
        Number first = p.first;
        Number last = p.last;
        return first.intValue() + last.intValue();
    }

    public  void firstExample(){
        String[] s1 = {"asa","dfgs"};
        String[] s = new String[]{"asa","wer"};
        Arrays.sort(s);
        Class c = String.class;
        Constructor[] cons = c.getConstructors();
        System.out.println(cons);
        if (s instanceof  String[]){

        }
    }

    public void proxyExample(){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                System.out.println(method.getDeclaredAnnotations().toString());

                if (method.getName().equals("morning")){
                    AnnotationExample ann = method.getAnnotation(AnnotationExample.class);
                    System.out.println(ann.value()+",morning，"+args[0]);
                }
                return null;
            }
        };

        PersonInterface pi = (PersonInterface) Proxy.newProxyInstance(
                PersonInterface.class.getClassLoader(),
                new Class[]{PersonInterface.class},
                handler
        );
        pi.morning("王富冬");
    }

    public void annotationExample(Person pi){
        for (Method method: pi.getClass().getMethods()) {
            AnnotationExample ae = method.getAnnotation(AnnotationExample.class);
            if (ae != null){
                try {
                    method.invoke(pi,ae.value()+",王富冬");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void reflectExample() throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person("王");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        Object o = f.get(p);
        System.out.println(o);

    }

    public void mapFirst(){
        Map map = new HashMap();
        Map currntMap = new ConcurrentHashMap();
        Class c = HashMap.class;
        System.out.println(c.getCanonicalName());
    }

    public void singleNumber(){
        int[] nums = {3,3,3,5};
//        String[] s = new String[]{};
        int res = 0;
        for(int i = 0;i < 32;++i){
            int sum = 0;
            for(int j = 0;j < nums.length;++j){
                sum += (nums[j] >> i) & 1;
                System.out.println("第"+j+"个数字，右移"+i+"位："+(nums[j] >> i));
//                System.out.println("你好"+"nihao");
            }

            res ^= (sum % 3) << i;
        }
        System.out.println(res);
    }

}
