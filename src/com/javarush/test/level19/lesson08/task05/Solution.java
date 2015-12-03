package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream fout = new FileOutputStream(br.readLine());

            PrintStream cOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outputStream));
            testString.printSomething();
            System.setOut(cOut);

            System.out.println(outputStream.toString());
            fout.write(outputStream.toByteArray());
            fout.close();
        } catch (IOException ignore) {}

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

