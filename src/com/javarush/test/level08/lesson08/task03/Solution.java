package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("F0", "N0");
        map.put("F1", "N0");
        map.put("F2", "N1");
        map.put("F3", "N1");
        map.put("F4", "N2");

        map.put("F5", "N3");
        map.put("F6", "N3");
        map.put("F7", "N4");
        map.put("F8", "N4");
        map.put("F9", "N5");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //Напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> i : map.entrySet())
            if (i.getValue().equals(name))
                count++;
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya) {
        //Напишите тут ваш код
        if (map.containsKey(familiya))
            return 1;
        else
            return 0;
    }
}
