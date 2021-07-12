package com.multithreading.runnableinterface;

public class Multiply implements Runnable{
    private int[] nums = {12, 45,67,89,10, 32, 64, 85, 90};
    public void run(){
        calculate();
    }
    public void calculate(){
        int product = 1;
        for(int num : nums){
            product = product*num;
        }
        //System.out.println("Multiply::");
        //System.out.print(product);
        //System.out.println("");
    }
}
