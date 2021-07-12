package com.multithreading.interthreadcomminication;

public class NerdyParent implements Runnable{

    Book book;

    public NerdyParent(Book book) {
        this.book = book;
        Thread buying = new Thread(this, "Buying");
        buying.start();
    }
    int noOfBooks = 0;
    @Override
    public void run() {
        while (true){
            try {
                book.buy(++noOfBooks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
