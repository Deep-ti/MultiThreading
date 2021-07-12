package com.multithreading.runnableinterface;

public class SquareOf implements Runnable{
    private int[] nums = {12, 45,67,89,10, 32, 64, 85, 90};
    public void run(){
        calculate();
    }
    public void calculate(){
        //System.out.println("Squared::");
        for(int num : nums){
            Math.pow(num, 2);
        }
        //System.out.println("");
    }
}
