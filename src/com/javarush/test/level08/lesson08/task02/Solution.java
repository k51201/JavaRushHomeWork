package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //Напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);

        set.add(10);
        set.add(11);
        set.add(12);
        set.add(13);
        set.add(14);

        set.add(15);
        set.add(16);
        set.add(17);
        set.add(18);
        set.add(19);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //Напишите тут ваш код
        Iterator<Integer> i = set.iterator();
        while (i.hasNext()) {
            Integer a = i.next();
            if (a > 10)
                i.remove();
        }
        return set;
    }
}
