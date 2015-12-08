package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do {
                String fileName = br.readLine();
                FileInputStream fin = new FileInputStream(fileName);
                if (fin.available() < 1000) {
                    br.close();
                    fin.close();
                    throw new DownloadException();
                }
                fin.close();
            } while (true);
        } catch (IOException ignore) {}
    }

    public static class DownloadException extends Exception{

    }
}
