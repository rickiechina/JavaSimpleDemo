package com.company;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

    public static void main(String[] args){

        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(new MyDate(), queue);
        // 假象引用，在实例化后，就被终止了。
        System.gc();
    }
}
