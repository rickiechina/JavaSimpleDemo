package com.stringdemo;

public class StringTest {

    public static void main(String[] args){
        String a = "hello";
        String b =  new String("hello");
        String c =  new String("hello");
        String d = b.intern();

        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(b==d);
        System.out.println(a==d);
    }
}
