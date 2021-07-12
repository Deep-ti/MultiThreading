package com.multithreading.interthreadcomminication;

public class Book {
    int noOfBooks;
    boolean finishedReading = true;

    public synchronized void buy(int noOfBooks) throws InterruptedException {
        while (!finishedReading){
            wait();
        }
        this.noOfBooks = noOfBooks;
        System.out.println("Bought "+ this.noOfBooks+" books.");
        finishedReading = false;
        notify();
    }
    public synchronized void read() throws InterruptedException {
        while (finishedReading){
            wait();
        }
        System.out.println("Bought "+ this.noOfBooks+" books.");
        finishedReading = true;
        notify();
    }
}
