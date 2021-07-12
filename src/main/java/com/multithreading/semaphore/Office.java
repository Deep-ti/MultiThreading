package com.multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Office {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread emp1 = new Thread( () -> {
            printer.run();
        });
        Thread emp2 = new Thread( () -> {
            printer.run();
        });
        Thread emp3 = new Thread( () -> {
            printer.run();
        });
        Thread emp4 = new Thread( () -> {
            printer.run();
        });
        Thread emp5 = new Thread( () -> {
            printer.run();
        });
        Thread emp6 = new Thread( () -> {
            printer.run();
        });
        Thread emp7 = new Thread( () -> {
            printer.run();
        });
        Thread emp8 = new Thread( () -> {
            printer.run();
        });
        Thread emp9 = new Thread( () -> {
            printer.run();
        });
        Thread emp10 = new Thread( () -> {
            printer.run();
        });
        emp1.start();
        emp2.start();
        emp3.start();
        emp4.start();
        emp5.start();
        emp6.start();
        emp7.start();
        emp8.start();
        emp9.start();
        emp10.start();

    }
}
