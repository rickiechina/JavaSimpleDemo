package com.company.concurrentdemo;

import java.util.concurrent.*;

public class BlockingQueueTest {

    public class Basket {
        // 篮子，能够容纳3个苹果
        BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);

        public void produce() throws InterruptedException {
            // put方法放入一个苹果，若basket满了，等到basket有位置
            basket.put("An apple");
        }

        public String consume() throws InterruptedException {
            // take方法取出一个苹果，若basket为空，等到basket有苹果为止(获取并移除此队列的头部)
            return basket.take();
        }
    }

    // 定义苹果生产者
    class Producer implements Runnable{
        private String instance;
        private Basket basket;

        public Producer(String instance, Basket basket){
            this.instance = instance;
            this.basket = basket;
        }

        @Override
        public void run() {
            try{
                while(true){
                    System.out.println("生产者准备生产苹果：" + instance);
                    basket.produce();
                    System.out.println("--生产者生产苹果完毕：" + instance);

                    Thread.sleep(300);
                }
            }catch (InterruptedException ex){
                //ex.printStackTrace();
                System.out.println("producer interrupted ...");
            }
        }
    }

    class Consumer implements Runnable{
        private String instance;
        private Basket basket;

        public Consumer(String instance, Basket basket){
            this.instance = instance;
            this.basket = basket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // 消费苹果
                    System.out.println("消费者准备消费苹果：" + instance);
                    System.out.println(basket.consume());
                    System.out.println("--消费者消费苹果完毕：" + instance);
                    // 休眠1000ms
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                System.out.println("Consumer Interrupted");
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        BlockingQueueTest test = new BlockingQueueTest();

        // Create a basket
        Basket basket = test.new Basket();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = test.new Producer("Producer 001", basket);
        Producer producer2 = test.new Producer("Producer 002", basket);

        Consumer consumer = test.new Consumer("Consumer 001", basket);

        Future future = service.submit(producer);
        service.submit(producer2);
        service.submit(consumer);

        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdownNow();
        // 如果任务执行完成，future.get()方法会返回一个null。注意，future.get()方法会产生阻塞。
        System.out.println(future.get());
    }
}
