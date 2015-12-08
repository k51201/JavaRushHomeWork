package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream(args[0]);
            int curr, letterCount = 0;
            while ((curr = fin.read()) >= 0)
                if (((curr >= 'a') && (curr <= 'z')) || ((curr >= 'A') && (curr <= 'Z')))
                    letterCount++;
            fin.close();
            System.out.println(letterCount);
        } catch (Exception ignore) {}
    }
}
