package com.company;

public class StrongReferenceTest {

    public static void main(String[] args){
        MyDate date = new MyDate();
        // 即使显式调用了垃圾回收，但是用于date是强引用，date没有被回收。
        System.gc();
    }
}
