package com.company;

import java.util.Date;

public class MyDate extends Date {
    public  MyDate(){

    }

    // Overwrite finalize() method
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("obj [Date: " + this.getTime() +"] is gc.");
    }

    public String toString(){
        return "Date: " + this.getTime();
    }
}
