package com.company;

public class ImplicitGarbageRetrieve {

    public static void main(String[] args){

        MyDate date = new MyDate();
        date = null;
        // 虽然没有显式调用垃圾回收方法System.gc()，但是由于运行了耗费大量内存的方法，触发JVM进行垃圾回收。
        ReferenceTest.drainMemory();
    }
}
