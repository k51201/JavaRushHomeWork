package com.javarush.test.level14.lesson06.home01;

/**
 * Created by vampa on 21.01.15.
 */
class MoldovanHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 25;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
