package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
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

        byte[] bytesBuffer = outputStream.toByteArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < bytesBuffer.length; i++)
            if (bytesBuffer[i] > '0' && bytesBuffer[i] < '9')
                result.append((char)bytesBuffer[i]);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
