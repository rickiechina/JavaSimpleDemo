package com.company.weakhashmapdemo;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest2 {
    public static void main(String[] args) {
        Map<Integer, Object> map = new WeakHashMap<>();

        for(int i=0; i<10000; i++){
            Integer ii = new Integer(i);
            map.put(ii, new byte[i]);
        }
    }
}
