package com.company;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("1", "a");

        map.computeIfAbsent("2", e-> e+"1");

        map.computeIfPresent("1", (k, v) -> k + v);

        map.remove("1", "a");
        map.getOrDefault("2", "b");

        map.merge("1", "aaa", (k, v) -> k + v);
        map.merge("2", "bbb", (k, v) -> k + v);

        map.forEach((k, v) ->{
            System.out.println(k+ "-" + v);
        });
    }
}
