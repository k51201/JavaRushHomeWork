package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName0 = br.readLine();
            String fileName1 = br.readLine();
            br.close();

            FileInputStream fin0 = new FileInputStream(fileName0);
            byte[] buf = new byte[fin0.available()];
            fin0.read(buf);
            fin0.close();

            FileOutputStream fout = new FileOutputStream(fileName0);
            FileInputStream fin1 = new FileInputStream(fileName1);

            int curr;
            while ((curr = fin1.read()) >= 0)
                fout.write(curr);
            fin1.close();

            fout.write(buf);
            fout.close();
        } catch (IOException ignore) {}
    }
}
