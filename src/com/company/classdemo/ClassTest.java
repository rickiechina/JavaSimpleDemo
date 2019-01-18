package com.company.classdemo;

import java.lang.reflect.Field;
import java.net.URL;

public class ClassTest {

    private static int [] array = new int[3];
    private static int length = array.length;

    private static Class<One> one = One.class;
    private static Class<Another> another = Another.class;

    public static void main(String[] args) throws Exception {
        One oneObject = one.newInstance();
        oneObject.call();

        Another anotherObject = another.newInstance();
        anotherObject.speak();

        Field privateFieldInOne = one.getDeclaredField("inner");
        privateFieldInOne.setAccessible(true);
        privateFieldInOne.set(oneObject, "world changed.");

        System.out.println(oneObject.getInner());
        System.out.println(one.getName());

        // 查看本地类加载器
        ClassLoader c = ClassTest.class.getClassLoader();
        System.out.println(c);
        ClassLoader c1 = c.getParent();
        System.out.println(c1);
        ClassLoader c2 = c1.getParent();
        System.out.println(c2);

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls){
            System.out.println(url.toExternalForm());
        }
    }
}

class One {
    private String inner = "rickie lee";

    public void call(){
        System.out.println("hello world.");
    }

    public String getInner(){
        return inner;
    }
}

class Another{
    public void speak(){
        System.out.println("easy coding.");
    }
}
