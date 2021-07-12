package com.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TodaysTask {
    public static void main(String[] args) {
        ExecutorService employees = Executors.newFixedThreadPool(3);
        String[] tasks = {"Design Analysis", "Documentation", "Low level designing", "Developing",
                "Testing", "Versioning", "Reviewing", "Documenting", "Deploying", "Support"};
        for(String task : tasks){
            employees.submit(new Task(task));
        }
        employees.shutdown();
        System.out.println("All tasks submitted");
        try {
            employees.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks completed");
    }
}
