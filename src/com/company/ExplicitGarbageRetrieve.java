package com.company;

public class ExplicitGarbageRetrieve {

    public static void main(String[] args){
        MyDate date = new MyDate();
        date = null;
        // 调用了System.gc()，使JVM运行垃圾回收，MyDate的finalize()方法被运行。
        System.gc();
    }
}
