package com.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class Printer implements Runnable{
    Semaphore printers = new Semaphore(4);

    public void startPrinting() throws InterruptedException {
        printers.acquire();
        System.out.println("Started Printing " + printers.availablePermits());
    }
    public void finishPrinting() throws InterruptedException {
        System.out.println("Finished Printing " +printers.availablePermits());
        printers.release();
    }

    @Override
    public void run() {
        try {
            startPrinting();
            Thread.sleep(200);
            finishPrinting();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
