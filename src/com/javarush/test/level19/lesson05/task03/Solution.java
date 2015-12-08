package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fin = new FileReader(br.readLine());
            FileWriter fout = new FileWriter(br.readLine());
            br.close();

            StringBuffer wordBuffer = new StringBuffer();

            while (fin.ready()) {
                char curr = (char) fin.read();
                if ((curr >= '0') && (curr <= '9'))
                    wordBuffer.append(curr);
                else {
                    if (curr == ' ' || curr == '\n') {
                        fout.write(wordBuffer.toString());
                        fout.write(' ');
                    } else
                        do {/*NOP*/} while (fin.read() != ' ' && fin.ready());
                    wordBuffer.delete(0, wordBuffer.length());
                }
            }
            fout.write(wordBuffer.toString());

            fin.close();
            fout.close();
        } catch (IOException ebisOnoKonem) {}
    }
}
