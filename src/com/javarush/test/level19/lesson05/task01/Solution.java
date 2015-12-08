package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fin = new FileInputStream(br.readLine());
            FileOutputStream fout = new FileOutputStream(br.readLine());
            br.close();

            int curr;
            while (fin.available() > 1) {
                fin.read();
                if (fin.available() > 0) {
                    curr = fin.read();
                    fout.write(curr);
                }
            }
            fin.close();
            fout.close();
        } catch (IOException hersnim) {}
    }
}
