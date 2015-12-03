package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fin = new FileReader(br.readLine());
            br.close();

            StringBuffer wordBuf = new StringBuffer(5);
            int wordCounter = 0;

            while (fin.ready()) {
                char curr = (char) fin.read();

                if ((curr >= 'a') && (curr <= 'z') || (curr >= 'A') && (curr <= 'Z'))
                    wordBuf.append(curr);
                else {
                    if (wordBuf.toString().equals("world"))
                        wordCounter++;
                    wordBuf.delete(0, wordBuf.length());
                }
            }
            fin.close();

            System.out.println(wordCounter);
        } catch (IOException chtooosluchiiilasO_o) {}
    }
}
