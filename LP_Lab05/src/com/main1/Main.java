package com.main1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Parking parking1 = new Parking("first", 2);
        Parking parking2 = new Parking("second", 1);
        for (int i = 1; i < 50; ) {
            executorService.execute(new Car(parking1,i++,(int) (Math.random() * 100)));
            executorService.execute(new Car(parking2,i++, (int) (Math.random() * 100)));
        }
        executorService.shutdown();
    }
}
