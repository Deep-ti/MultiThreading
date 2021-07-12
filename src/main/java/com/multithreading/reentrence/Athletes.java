package com.multithreading.reentrence;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Athletes {
    private int distance =0;
    private Lock lock = new ReentrantLock();
    private Condition setFirstAthlete = lock.newCondition();
    private Condition setSecondAthlete = lock.newCondition();

    private void run(){
        for(int i =0; i < 50; i++){
            distance++;
        }
    }

    public void firstAthlete() throws InterruptedException{
        lock.lock();
        System.out.println("First Athlete ready");
        setFirstAthlete.await();
        System.out.println("First Athlete Running");
        try {
            run();
            System.out.println("Relay passed");
            setSecondAthlete.signal();
        }finally {
            lock.unlock();
        }
    }
    public void secondAthlete() throws InterruptedException{
        lock.lock();
        System.out.println("Second Athlete ready");
        System.out.println("Blow the whistle to run!!");
        new Scanner(System.in).nextLine();
        setFirstAthlete.signal();
        setSecondAthlete.await();
        System.out.println("Second Athlete Running");
        try {
            run();
        }finally {
            lock.unlock();
        }
    }
    public void finishRace(){
        System.out.println("Race Finished");
    }
}
