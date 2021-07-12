package com.multithreading.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Gateway {
    private Accounts acc1 = new Accounts();
    private Accounts acc2 = new Accounts();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLock(Lock firstLock, Lock secondLock) throws InterruptedException {
        while (true){
            boolean gotFirstLock =false;
            boolean gotSecondLock =false;

            try{
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            }finally {
                if(gotFirstLock && gotSecondLock){
                    return;
                }
                if(gotFirstLock){
                    firstLock.unlock();
                }
                if(gotSecondLock){
                    secondLock.unlock();
                }
            }
            Thread.sleep(1);
        }
    }

    public void firstUser() throws InterruptedException {
        Random random = new Random();
        for(int i=0; i < 10000; i++){
            System.out.println("Acquire locks for first user.");
            acquireLock(lock1, lock2);
            try{
                Accounts.transfer(acc1, acc2, random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }

        }
    }
    public void secondUser() throws InterruptedException {
        Random random = new Random();
        for(int i=0; i < 10000; i++){
            System.out.println("Acquire locks for second user.");
            acquireLock(lock2, lock1);
            try{
                Accounts.transfer(acc2, acc1, random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }

    }
    public void finish(){
        System.out.println("Account 1 balance is : " + acc1.getBalance());
        System.out.println("Account 2 balance is : " + acc2.getBalance());
        System.out.println("Total is : " + (acc1.getBalance()+ acc2.getBalance()));
    }
}
