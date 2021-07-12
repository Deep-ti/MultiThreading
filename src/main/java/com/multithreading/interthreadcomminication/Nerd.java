package com.multithreading.interthreadcomminication;

public class Nerd implements Runnable{

    Book book;

    public Nerd(Book book) {
        this.book = book;
        Thread buying = new Thread(this, "Reading");
        buying.start();
    }

    @Override
    public void run() {
        while (true){
            try {
                book.read();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
