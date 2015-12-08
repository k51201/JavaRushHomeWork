package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream(args[0]);

            int[] counters = new int[256];
            while (fin.available() > 0)
                counters[fin.read()]++;
            fin.close();

            for (char i = 0; i < counters.length; i++)
                if (counters[i] > 0)
                    System.out.println("" + i + " " + counters[i]);
        } catch (IOException ignore) {}
    }
}
