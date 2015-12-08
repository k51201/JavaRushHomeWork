package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fin = new FileReader(args[0]);
            FileWriter fout = new FileWriter(args[1]);

            StringBuilder currWord = new StringBuilder();
            boolean firstEntry = true;

            while (fin.ready()) {
                char sym = (char) fin.read();
                if (sym == ' ' || sym == '\n' || sym == '\r' || !fin.ready()) {
                    if (6 < currWord.length()) {
                        if (!firstEntry)
                            fout.write(',');
                        fout.write(currWord.toString());
                        if (!fin.ready())
                            fout.write(sym);
                        firstEntry = false;
                    }
                    currWord = new StringBuilder();
                } else
                    currWord.append(sym);
            }

            fin.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
