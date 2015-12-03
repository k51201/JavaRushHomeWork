package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream fout = new FileOutputStream(br.readLine());
            FileInputStream fin2 = new FileInputStream(br.readLine());
            FileInputStream fin3 = new FileInputStream(br.readLine());
            br.close();

            int curr;
            while ((curr = fin2.read()) >= 0)
                fout.write(curr);
            fin2.close();
            while ((curr = fin3.read()) >= 0)
                fout.write(curr);
            fin3.close();
            fout.close();
        } catch (IOException e) {}
    }
}
