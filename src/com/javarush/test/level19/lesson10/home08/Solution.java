package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fin = new BufferedReader(new FileReader(consoleReader.readLine()));
            consoleReader.close();

            while (fin.ready()) {
                StringBuffer line = new StringBuffer(fin.readLine());
                System.out.println(line.reverse());
            }
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
