package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));

        //Напишите тут ваш код
        map.put("n0", new Date("JULY 1 1990"));
        map.put("n1", new Date("JUNE 1 1980"));
        map.put("n2", new Date("JUNE 1 1980"));
        map.put("n3", new Date("JUNE 1 1980"));

        map.put("n4", new Date("JUNE 1 1980"));
        map.put("n5", new Date("JUNE 1 1980"));
        map.put("n6", new Date("JUNE 1 1980"));
        map.put("n7", new Date("JUNE 1 1980"));
        map.put("n8", new Date("JUNE 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //Напишите тут ваш код

        Iterator<Map.Entry<String, Date>> i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String, Date> pair = i.next();
            int month = pair.getValue().getMonth();
            if (month > 4 && month < 8)
                i.remove();
        }
    }
}
