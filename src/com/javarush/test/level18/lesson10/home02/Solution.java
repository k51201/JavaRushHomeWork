package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream(args[0]);
            int curr,
                    nSym = 0,
                    nSpc = 0;
            while ((curr = fin.read()) >= 0) {
                nSym++;
                if (curr == ' ')
                    nSpc++;
            }
            fin.close();
            double spcFreq = (double)nSpc/nSym*100;
            System.out.println(String.format("%.2f", spcFreq));
        } catch (IOException ignore) {}
    }
}
