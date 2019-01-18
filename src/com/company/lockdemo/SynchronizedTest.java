package com.company.lockdemo;

public class SynchronizedTest {
    private static Object lock = new Object();
    private static int i=0;

    public static void main(String[] args) {
        method1();
        method2();
    }

    synchronized static void method1(){
        i++;
    }
    synchronized static void method2(){
        i--;
    }
}
