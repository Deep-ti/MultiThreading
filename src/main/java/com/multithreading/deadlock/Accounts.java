package com.multithreading.deadlock;

public class Accounts {
    private int balance;

    public void deposit(int amount){
        balance += amount;
    }
    public void withdraw(int amount){
        balance -= amount;
    }

    public int getBalance(){
        return balance;
    }

    public static void transfer(Accounts acc1, Accounts acc2, int amount){
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
