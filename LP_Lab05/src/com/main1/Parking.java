package com.main1;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Parking {
    private ArrayList<Car> cars;
    private Integer size;
    private String name;
    private Semaphore semaphore;

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public Parking(String name, int size) {
        cars = new ArrayList<>(size);
        this.size = size;
        this.name = name;
        semaphore = new Semaphore(getSize(),true);
    }

    public void Add(Car car) {
        cars.add(car);
    }

    public void Delete(Car car) {
        cars.remove(car);
    }


}
