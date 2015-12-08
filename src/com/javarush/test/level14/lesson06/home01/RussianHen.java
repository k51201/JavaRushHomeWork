package com.javarush.test.level14.lesson06.home01;

/**
 * Created by vampa on 21.01.15.
 */
class RussianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 22;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
