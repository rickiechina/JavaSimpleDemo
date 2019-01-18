package com.company.countdowndemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int n = 5;
        CyclicBarrier barrier = new CyclicBarrier(n);

        for(int i=0; i< n; i++)
            new WriterDB(barrier).start();
    }
}

class WriterDB extends Thread{
    private CyclicBarrier cyclicBarrier;

    public WriterDB(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " is waiting ...");

        try {
            Thread.sleep(1000);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " continues to work.");
    }
}
