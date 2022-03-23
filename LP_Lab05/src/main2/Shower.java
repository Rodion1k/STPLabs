package main2;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Shower extends Semaphore {
    private ArrayList<Human> humans;
    private int size;
    volatile int Come;
    volatile char genderInShower;

    public Shower(int permits) {
        super(permits);
        this.size = permits;
    }

    public boolean showerStatus(char gender) {
        synchronized (this) {
            if (this.Come == 0) {
                this.genderInShower = gender;
                return true;
            } else {
                if (this.Come == size && this.genderInShower != gender)
                    this.genderInShower = gender;
                return switch (gender) {
                    case 0 -> this.genderInShower == 0 && this.Come != size;
                    case 1 -> this.genderInShower == 1 && this.Come != size;
                    default -> false;
                };
            }
        }
    }

    public void setGenderInShower(char genderInShower) {
        this.genderInShower = genderInShower;
    }

    public void acquire(Man male) throws InterruptedException { // получение у семафора разрешения
        Random randNum = new Random();
        Object obj1 = new Object();
        Object obj2 = new Object();
        synchronized (obj1) {
            System.out.println(String.format("%s guest %d goes in", male.getGender(), male.getId()));
        }
        male.sleep(randNum.nextInt(1000) + 500);
        synchronized (obj2) {
            System.out.println(String.format("m guest %d goes out", male.getId()));
        }
    }

    public void acquire(Woman female) throws InterruptedException {
        Random randNum = new Random();
        Object obj1 = new Object();
        Object obj2 = new Object();
        synchronized (obj1) {
            System.out.printf("%s female %d goes in%n", female.getGender(), female.getId());
        }
        female.sleep(randNum.nextInt(1000) + 1000);
        synchronized (obj2) {
            System.out.printf("w female %d goes out%n", female.getId());
        }
    }

    public void acquire(Human user) throws InterruptedException {
        super.acquire();
        this.Come++;
        if (user.getGender() == 'w') {
            this.acquire((Woman) user);
        } else {
            this.acquire((Man) user);
        }
        this.Come--;
    }

    public int size() {
        return humans.size();
    }

    public Integer getSize() {
        return size;
    }

    public void Add(Human human) {
        humans.add(human);
    }

    public void Delete(Human human) {
        humans.remove(human);
    }
}
