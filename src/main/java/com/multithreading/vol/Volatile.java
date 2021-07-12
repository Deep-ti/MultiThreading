package com.multithreading.vol;

import java.util.Scanner;

class Talk extends  Thread{
    private volatile boolean shush;
    public void run() {
        while (!shush){
            System.out.print("Blah ");
        }
    }

    public void shutUp(){
        System.out.println("SHUTTT UPPP!");
        shush = true;
    }
}
public class Volatile {
    public static void main(String[] args) {
        Talk talk = new Talk();
        talk.start();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        talk.shutUp();
    }
}
