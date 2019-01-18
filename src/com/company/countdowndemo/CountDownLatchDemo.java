package com.company.countdowndemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(()->{
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() +"执行完毕");
                latch.countDown();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println("Sub thread " + Thread.currentThread().getName() + " is running ...");
                Thread.sleep(3000);
                System.out.println("Sub thread " + Thread.currentThread().getName() +" completes.");
                latch.countDown();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

//        Runnable run = System.out::println;
//        new Thread(run).start();

        System.out.println("Waiting for sub threads completion.");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All complete.");
        System.out.println("Continue main thread ...");
    }

}
