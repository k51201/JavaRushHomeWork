package com.javarush.test.level14.lesson06.home01;

/**
 * Created by vampa on 21.01.15.
 */
abstract class Hen {

    abstract int getCountOfEggsPerMonth();

    String getDescription() {
        return "Я курица.";
    }
}