package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //Напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<String> numbers = new ArrayList<String>();

        // разбираем
        for (int i = 0; i < array.length; i++)
            if (isNumber(array[i]))
                numbers.add(array[i]);
            else
                strings.add(array[i]);

        // сортировка строк
        for (int i = 0; i < strings.size() - 1; i++)
            for (int j = i; j < strings.size(); j++)
                if (isGreaterThen(strings.get(i), strings.get(j))) {
                    String buf = strings.get(i);
                    strings.set(i, strings.get(j));
                    strings.set(j, buf);
                }

        // сортировка чисел
        for (int i = 0; i < numbers.size() - 1; i++)
            for (int j = i; j < numbers.size(); j++)
                if (Integer.parseInt(numbers.get(i)) < Integer.parseInt(numbers.get(j))) {
                    String buf = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, buf);
                }

        // собираем
        int n = 0;
        int s = 0;
        for (int i = 0; i < array.length; i++)
            if (isNumber(array[i]))
                array[i] = numbers.get(n++);
            else
                array[i] = strings.get(s++);
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b) {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) { // не цифра и не начинается с '-'
                return false;
            }
        }
        return true;
    }
}
