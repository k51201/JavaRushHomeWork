package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fin = new FileReader(br.readLine());
            FileWriter fout = new FileWriter(br.readLine());
            br.close();

            while (fin.ready()) {
                char curr = (char) fin.read();
                if (curr == '.')
                    curr = '!';
                fout.write(curr);
            }

            fin.close();
            fout.close();
        } catch (IOException nuNePovezlo) {}
    }
}
