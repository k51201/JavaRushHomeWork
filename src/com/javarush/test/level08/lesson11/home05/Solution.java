package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //Напишите тут ваш код
        StringBuffer sb = new StringBuffer(s);
        boolean nextUp = true;
        for (int i = 0; i < sb.length(); i++) {
            if (nextUp) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                nextUp = false;
            }
            if (sb.charAt(i) == ' ')
                nextUp = true;
        }
        s = new String(sb);
        System.out.println(s);
    }


}
