package com.multithreading.deadlock;

public class PaymentApp {
    public static void main(String[] args) throws InterruptedException {
        final Gateway gateway = new Gateway();
        Thread transactionOne = new Thread(() ->{
            try{
                gateway.firstUser();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        Thread transactionTwo = new Thread(() ->{
            try{
                gateway.secondUser();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        transactionOne.start();
        transactionTwo.start();
        transactionOne.join();
        transactionTwo.join();
        gateway.finish();
    }
}
