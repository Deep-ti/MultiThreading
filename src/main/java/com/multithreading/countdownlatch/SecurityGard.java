package com.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecurityGard {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(200);
        ExecutorService workers = Executors.newFixedThreadPool(200);
        for(int i = 0; i < 200; i++){
            workers.submit(new Entry(countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Gates Closed");
    }
}
