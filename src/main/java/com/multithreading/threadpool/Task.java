package com.multithreading.threadpool;

public class Task implements Runnable{
    private String task;
    public Task(String task){
        this.task = task;
    }
    @Override
    public void run() {
        System.out.println("Starting "+ task);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished "+task);
    }
}
