package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by vampa on 02.02.2016.
 */
public class Hippodrome {
    public static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse plotva = new Horse("Плотва", 3, 0);
        Horse shadowmere = new Horse("Тенегрив", 3, 0);
        Horse bucefal = new Horse("Буцефал", 3, 0);

        game.getHorses().add(plotva);
        game.getHorses().add(shadowmere);
        game.getHorses().add(bucefal);

        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses)
            horse.move();
    }

    public void print() {
        for (Horse horse : horses)
            horse.print();
        System.out.println();
        System.out.println();
    }
}
