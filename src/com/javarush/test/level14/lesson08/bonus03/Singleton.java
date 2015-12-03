package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by vampa on 21.01.15.
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
        instance = this;
    }

    static Singleton getInstance() {
        if (instance == null)
            return new Singleton();
        else
            return instance;
    }
}
