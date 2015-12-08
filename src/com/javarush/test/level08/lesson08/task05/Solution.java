package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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
        map.put("F6", "N4");
        map.put("F7", "N4");
        map.put("F8", "N5");
        map.put("F9", "N2");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //Напишите тут ваш код
        HashSet<String> unique = new HashSet(map.values());
        HashSet<String> duplicates = new HashSet<String>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();
            if (unique.contains(value))
                unique.remove(value);
            else
                duplicates.add(value);
        }
        for (String value : duplicates)
            removeItemFromMapByValue(map, value);
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
