package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String finName = br.readLine();
            String foutName0 = br.readLine();
            String foutName1 = br.readLine();
            br.close();

            FileInputStream fin = new FileInputStream(finName);

            int finHalf;
            if ((fin.available() % 2) == 0)
                finHalf = fin.available() / 2;
            else
                finHalf = (fin.available() / 2) + 1;

            byte[] buffer0 = new byte[finHalf];
            byte[] buffer1 = new byte[fin.available() - finHalf];

            FileOutputStream fout0 = new FileOutputStream(foutName0);
            FileOutputStream fout1 = new FileOutputStream(foutName1);

            fin.read(buffer0, 0, finHalf);
            fout0.write(buffer0, 0, finHalf);

            finHalf = fin.read(buffer1);
            fout1.write(buffer1, 0, finHalf);

            fin.close();
            fout0.close();
            fout1.close();
        } catch (IOException ignore) {}
    }
}
