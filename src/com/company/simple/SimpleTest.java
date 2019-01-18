package com.company.simple;

public class SimpleTest {
    public int simpleMethod(){
        int x=13;
        int y=14;
        int z = x+y;

        return z;
    }

    public static void main(String[] args) {
        System.out.println(new SimpleTest().simpleMethod());
    }
}
