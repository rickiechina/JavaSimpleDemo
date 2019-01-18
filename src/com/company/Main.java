package com.company;

public class Main {

    public int x = 100;

    public static void main(String[] args) {

        Main main1 = new Main();
        int y = 500;
        y = y+ main1.x;

        System.out.println(y);
    }
}
