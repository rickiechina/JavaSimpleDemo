package com.company.weakhashmapdemo;

import java.util.HashMap;
import java.util.Map;

public class WeakHashMapTest {
    public static void main(String[] args) {
        Map<Integer, Object> map = new HashMap<>();

        for(int i=0; i<10000; i++){
            Integer ii = new Integer(i);
            map.put(ii, new byte[i]);
        }
    }
}
