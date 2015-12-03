package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution {
    public static HashSet<String> createSet() {
        //Напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        set.add("Лилия");
        set.add("Лавка");
        set.add("Лила");
        set.add("Лысый");
        set.add("Ловкач");

        set.add("Лайка");
        set.add("Лето");
        set.add("Ласты");
        set.add("Линк");
        set.add("Лобзик");

        set.add("Лейкопластырь");
        set.add("Лейка");
        set.add("Люк");
        set.add("Лицо");
        set.add("Лапа");

        set.add("Лекарь");
        set.add("Лом");
        set.add("Лекало");
        set.add("Лейбл");
        set.add("Лидинахуй");

        return set;
    }
}
