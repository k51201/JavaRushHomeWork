package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fin = new FileReader(args[0]);
            FileWriter fout = new FileWriter(args[1]);

            StringBuilder currWord = new StringBuilder();
            boolean hasDigit = false;
            while (fin.ready()) {
                char sym = (char) fin.read();

                if (sym == ' ' || !fin.ready()) {
                    if (hasDigit)
                        fout.write(currWord.append(' ').toString());
                    hasDigit = false;
                    currWord = new StringBuilder();
                } else {
                    currWord.append(sym);
                    if (!hasDigit && '0' <= sym && sym <= '9')
                        hasDigit = true;
                }
            }

            fin.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
