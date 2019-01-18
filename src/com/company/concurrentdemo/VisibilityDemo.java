package com.company.concurrentdemo;

import java.util.concurrent.TimeUnit;

public class VisibilityDemo {
    private static volatile boolean is = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(VisibilityDemo.is){
                    //synchronized (this) {
                        i++;
                    //}
                }
                System.out.println(i);
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);

        VisibilityDemo.is = false;
        System.out.println("Has been set to FALSE.");
    }
}
