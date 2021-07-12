package com.multithreading.synchronize;

public class Count {
    int count = 0;
    public synchronized void increment(){
        count++;
    }
}
