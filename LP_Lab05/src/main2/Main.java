package main2;

public class Main {

    public static void main(String[] args) {
        Shower shower = new Shower(2);
        Man m1 = new Man(1, shower);
        Man m2 = new Man(2, shower);
        Man m3 = new Man(3, shower);
        Man m4 = new Man(4, shower);
        Woman f1 = new Woman(1, shower);
        Woman f2 = new Woman(2, shower);
        Woman f3 = new Woman(3, shower);
        Woman f4 = new Woman(4, shower);
        f1.start();
        f2.start();
        m1.start();
        m2.start();
        m3.start();
        f3.start();
        m4.start();
        f4.start();

    }
}


