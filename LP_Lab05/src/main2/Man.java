package main2;

import java.util.concurrent.CyclicBarrier;

public class Man extends Human{
    public Man(int id, Shower shower) {
        super(id, shower);
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public char getGender() {
        return 'm';
    }
}
