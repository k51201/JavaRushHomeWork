package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fInName = br.readLine();
            String fOutName = br.readLine();
            br.close();

            FileInputStream fIn = new FileInputStream(fInName);
            byte[] buffer = new byte[fIn.available()];
            fIn.read(buffer);
            fIn.close();

            FileOutputStream fOut = new FileOutputStream(fOutName);
            for (int i = buffer.length - 1; i >= 0; i--)
                fOut.write(buffer[i]);
            fOut.close();
        } catch (IOException e) {}
    }
}
