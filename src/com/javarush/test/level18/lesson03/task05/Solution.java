package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileInputStream fin = new FileInputStream(fileName);
        int[] byteCount = new int[256];
        while (fin.available() > 0)
            byteCount[fin.read()]++;
        fin.close();

        for (int i = 0; i < 255; i++)
            if (byteCount[i] > 0)
                System.out.print("" + i + " ");
    }
}
