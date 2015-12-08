package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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

        int minCount = 256;
        for (int i = 0; i < 255; i++)
            if ((byteCount[i] > 0) && (byteCount[i] < minCount))
                minCount = byteCount[i];

        for (int i = 0; i < 255; i++)
            if (byteCount[i] == minCount)
                System.out.print("" + i + " ");
    }
}
