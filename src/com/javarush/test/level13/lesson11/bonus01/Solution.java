package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(new File(br.readLine()));
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (sc.hasNext())
            numbers.add(sc.nextInt());
        sc.close();

        for (int i = 0; i < numbers.size();)
            if (numbers.get(i) % 2 != 0)
                numbers.remove(i);
            else
                i++;

        for (int i = 0; i < numbers.size() - 1; i++)
            for (int j = i + 1; j < numbers.size(); j++)
                if (numbers.get(i) > numbers.get(j)) {
                    int buf = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, buf);
                }

        for (Integer a : numbers) {
            System.out.println(a);
        }

    }
}
