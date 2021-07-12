package com.multithreading.reentrence;

public class Reentrance {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("In a relay race two athlete are expected to cover 100m (50m each). " +
                "Relay is with or 'locked by' first athlete.");
        final Athletes athletes = new Athletes();
        Thread t1 = new Thread(() -> {
            try {
                athletes.firstAthlete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                athletes.secondAthlete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        athletes.finishRace();
    }
}
