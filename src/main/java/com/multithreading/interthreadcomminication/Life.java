package com.multithreading.interthreadcomminication;

public class Life {
    public static void main(String[] args) {
        Book b = new Book();
        new NerdyParent(b);
        new Nerd(b);
    }
}
