package com.company.weakhashmapdemo;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class WeakHashMapTest3 {
    public static void main(String[] args) throws InterruptedException {
        Map<Object, Object> map = new WeakHashMap();
        map.put(null, new byte[5*1024*600]);
        int i=1;
        while(true){
            TimeUnit.SECONDS.sleep(2);
            System.out.println(map.size());
            System.gc();
            System.out.println("==== 第" + i++ +"次GC结果 ====" );

            if(i==5){
                map.remove(null);
                TimeUnit.SECONDS.sleep(5);
                System.gc();
                System.out.println("==== 第" + 5 +"次GC结果 ====" );
                break;
            }
        }
    }
}
