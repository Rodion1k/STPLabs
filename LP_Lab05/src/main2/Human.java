package main2;

import java.util.Random;

public abstract class Human extends Thread {
    private final Shower shower;
    private final int id;

    public Human(int id, Shower shower) {
        this.id = id;
        this.shower = shower;
    }

    @Override
    public long getId() {
        return id;
    }

    public abstract char getGender();


    private void showing() {
        System.out.println("Human # " + id + " gender: " + this.getClass().getSimpleName() + " starting get shower");
    }

    private void leaving() {
        System.out.println("Human # " + id + " gender: " + this.getClass().getSimpleName() + " leaving shower");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " id: " + id;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            if(!shower.showerStatus(this.getGender()))
            {
                do {
                    sleep(1000);
                } while (!shower.showerStatus(this.getGender()));
            }
            shower.setGenderInShower(getGender());
            shower.acquire(this);
            shower.release();

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
