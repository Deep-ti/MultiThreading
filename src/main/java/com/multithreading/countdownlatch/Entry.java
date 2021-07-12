package com.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Entry implements Runnable{
    private CountDownLatch countDownLatch;
    public Entry(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Entering");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
