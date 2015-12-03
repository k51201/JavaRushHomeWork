package com.javarush.test.level14.lesson08.home09;

/**
 * Created by vampa on 21.01.15.
 */
class Hrivna extends Money {
    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "HRN";
    }
}
