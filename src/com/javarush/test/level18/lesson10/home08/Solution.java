package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean exit = false;

            while (!exit) {
                String fileName = br.readLine();
                if (!fileName.equals("exit")) {
                    new ReadThread(fileName).start();
                } else
                    exit = true;
            }

            br.close();
        } catch (IOException vPech) {}
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                FileInputStream fin = new FileInputStream(Thread.currentThread().getName());

                Map<Integer, Integer> byteCounter = new HashMap<Integer, Integer>();
                while (fin.available() > 0) {
                    int curr = fin.read();
                    if (byteCounter.containsKey(curr))
                        byteCounter.put(curr, (byteCounter.get(curr) + 1));
                    else
                        byteCounter.put(curr, 1);
                }
                fin.close();

                int maxValue = Integer.MIN_VALUE;
                int freqByte = 0;
                for (Map.Entry<Integer, Integer> entry : byteCounter.entrySet())
                    if (entry.getValue() > maxValue) {
                        freqByte = entry.getKey();
                        maxValue = entry.getValue();
                    }

                resultMap.put(Thread.currentThread().getName(), freqByte);
            } catch (IOException fTopku) {}
        }

    }
}
