package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream cOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        System.setOut(cOut);

        StringBuilder result = new StringBuilder(outputStream.toString());

        int pos = result.indexOf(" ");
        int argA = Integer.parseInt(result.substring(0, pos));
        char oper = result.charAt(pos + 1);
        pos += 3;
        int argB = Integer.parseInt(result.substring(pos, result.indexOf(" ", pos)));


        if (oper == '+')
            result.append(argA + argB);
        else if (oper == '-')
            result.append(argA - argB);
        else if (oper == '*')
            result.append(argA * argB);

        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

