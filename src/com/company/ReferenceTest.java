package com.company;

public class ReferenceTest {

    public ReferenceTest(){

    }

    // Consume lots of memory
    public static void drainMemory(){
        String[] array = new String[1024 * 1000];
        for(int i = 0; i<1024 * 1000; i++){
            for(int j = 'a'; j <= 'z'; j++){
                array[i] += (char)j;
            }
        }
    }
}
