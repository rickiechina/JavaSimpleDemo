package com.company;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static void main(String[] args){
        WeakReference ref = new WeakReference(new MyDate());

        System.out.println(ref.get());
        //MyDate date = (MyDate)ref.get();
        //System.out.println("Date ToString():" + date.toString());

        // 在JVM垃圾回收运行时，弱引用被终止.
        System.gc();

        System.out.println(ref.get());
    }
}
