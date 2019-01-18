package com.company.concurrentdemo;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);

//        queue.add("hello");
//        queue.add("world");
//        queue.add("yes");
//        queue.put("hello");
//        queue.put("world");
//        queue.put("yes");
//
//        System.out.println("====");

        boolean bol1=queue.offer("hello");
        boolean bol2=queue.offer("world");
        boolean bol3=queue.offer("yes");

        System.out.println(queue.toString());
        System.out.println(bol1);
        System.out.println(bol2);
        System.out.println(bol3);
    }
}
