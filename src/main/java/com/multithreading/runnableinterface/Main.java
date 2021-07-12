package com.multithreading.runnableinterface;

import com.multithreading.threadclass.Multiply;
import com.multithreading.threadclass.SquareOf;

public class Main {
    static long startTime;
    static long endTime;
    static long timeElapsed;
    static private int[] nums = {12, 45, 67, 89, 10, 32, 64, 85, 90};

    public static void main(String[] args) throws InterruptedException {
        startTime = System.nanoTime();
        com.multithreading.runnableinterface.Multiply mul = new com.multithreading.runnableinterface.Multiply();
        com.multithreading.runnableinterface.SquareOf sq = new com.multithreading.runnableinterface.SquareOf();
        mul.calculate();
        sq.calculate();
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Thread Execution time without multithreading in microseconds: " + timeElapsed/1000);
        mainThread();
        mainRunnable();
        mainAnonymous();
        mainLambda();
        mainLambdaOptimized();
    }

    private static void mainLambdaOptimized() throws InterruptedException {
        startTime = System.nanoTime();
        Thread mulThread = new Thread(() -> {
            int product = 1;
            for (int num : nums) {
                product = product * num;
            }
            //System.out.println("Multiply::");
            //System.out.print(product);
            //System.out.println("");
        });
        Thread sqThread = new Thread(() -> {
            //System.out.println("Squared::");
            for (int num : nums) {
                Math.pow(num, 2);
            }
            //System.out.println("");
        });
        mulThread.start();
        sqThread.start();
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Optimized Lambda Execution time with multithreading in microseconds: " + timeElapsed/1000);
        mulThread.join();
        sqThread.join();
    }


    private static void mainLambda() throws InterruptedException {
        startTime = System.nanoTime();
        Runnable mulRun = () -> {
            int product = 1;
            for (int num : nums) {
                product = product * num;
            }
            //System.out.println("Multiply::");
            //System.out.print(product);
            //System.out.println("");
        };
        Runnable sqRun = () -> {
            //System.out.println("Squared::");
            for (int num : nums) {
                Math.pow(num, 2);
            }
            //System.out.println("");
        };
        Thread mulThread = new Thread(mulRun);
        Thread sqThread = new Thread(sqRun);
        mulThread.start();
        sqThread.start();
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Lambda Execution time with multithreading in microseconds: " + timeElapsed/1000);
        mulThread.join();
        sqThread.join();
    }


    private static void mainAnonymous() throws InterruptedException {
        startTime = System.nanoTime();
        Runnable mulRun = new Runnable() {
            @Override
            public void run() {
                int product = 1;
                for (int num : nums) {
                    product = product * num;
                }
                //System.out.println("Multiply::");
                //System.out.print(product);
                //System.out.println("");
            }
        };
        Runnable sqRun = new Runnable() {
            @Override
            public void run() {
                //System.out.println("Squared::");
                for (int num : nums) {
                    Math.pow(num, 2);
                }
                //System.out.println("");
            }
        };
        Thread mulThread = new Thread(mulRun);
        Thread sqThread = new Thread(sqRun);
        mulThread.start();
        sqThread.start();
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Anonymous Execution time with multithreading in microseconds: " + timeElapsed/1000);
        mulThread.join();
        sqThread.join();
    }

    private static void mainThread() throws InterruptedException {
        startTime = System.nanoTime();
        Thread mulThread = new Multiply();
        Thread sqThread = new SquareOf();
        mulThread.start();
        sqThread.start();
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Runnable Execution time with multithreading in microseconds: " + timeElapsed/1000);
        mulThread.join();
        sqThread.join();
    }

    private static void mainRunnable() throws InterruptedException {
        startTime = System.nanoTime();
        Runnable mulRun = new com.multithreading.runnableinterface.Multiply();
        Runnable sqRun = new com.multithreading.runnableinterface.SquareOf();
        Thread mulThread = new Thread(mulRun);
        Thread sqThread = new Thread(sqRun);
        mulThread.start();
        sqThread.start();
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("Thread Execution time with multithreading in microseconds: " + timeElapsed/1000);
        mulThread.join();
        sqThread.join();
    }
}
