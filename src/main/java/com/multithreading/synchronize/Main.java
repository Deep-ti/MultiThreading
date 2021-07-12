package com.multithreading.synchronize;

public class Main {
    public static void main(String[] args) {
        Count c = new Count();
        Runnable counter1 = () -> {
            for (int i = 0; i < 1000; i++)
                c.increment();
        };
        Runnable counter2 = () -> {
            for (int i = 0; i < 1000; i++)
                c.increment();
        };
        counter1.run();
        counter2.run();
        System.out.println("Count = " + c.count);
    }
}
