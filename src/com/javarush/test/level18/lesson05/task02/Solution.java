package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            br.close();
            FileInputStream fin = new FileInputStream(fileName);

            int zCount = 0;
            while (fin.available() > 0)
                if (fin.read() == ',')
                    zCount++;
            fin.close();
            System.out.println(zCount);
        } catch (IOException ignore) {/*NOP*/}
    }
}
