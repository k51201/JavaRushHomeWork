package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[10];
        int last = array.length - 1;
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < array.length; i++) {
            if (i * 2 <= last) {
                int buf = array[i];
                array[i] = array[last - i];
                array[last - i] = buf;
            }
            System.out.println(array[i]);
        }
    }
}
