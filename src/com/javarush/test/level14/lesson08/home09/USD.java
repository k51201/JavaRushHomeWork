package com.javarush.test.level14.lesson08.home09;

/**
 * Created by vampa on 21.01.15.
 */
class USD extends Money {
    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
