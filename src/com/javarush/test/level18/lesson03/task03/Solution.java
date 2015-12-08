package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
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

        int maxCount = 0;
        for (int i = 0; i < 255; i++)
            if (byteCount[i] > maxCount)
                maxCount = byteCount[i];

        for (int i = 0; i < 255; i++)
            if (byteCount[i] == maxCount)
                System.out.print("" + i + " ");
    }
}
