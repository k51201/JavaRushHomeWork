package com.javarush.test.level14.lesson06.home01;

/**
 * Created by vampa on 21.01.15.
 */
class BelarusianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 21;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
