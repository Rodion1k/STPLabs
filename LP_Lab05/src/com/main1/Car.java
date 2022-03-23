package com.main1;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private final int id;
    private final int minutes;
    private final Parking parking;

    public Car(Parking parking, int id, int minutes) {
        this.minutes = minutes;
        this.id = id;
        this.parking = parking;
    }

    private void parking() {
        System.out.println("Car #" + id + " parked on stand " + parking.getName());
    }

    private void leaving() {
        System.out.println("Car #" + id + " leaving stand " + parking.getName());
    }

    @Override
    public void run() {
        try {
            parking.getSemaphore().acquire();
            parking.Add(this);
            parking();
            Thread.sleep(minutes * 100L);
            parking.Delete(this);
            leaving();
            parking.getSemaphore().release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
