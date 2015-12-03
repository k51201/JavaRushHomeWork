package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (true) {
                    String fileName = br.readLine();
                    if (!(new File(fileName)).exists())
                        throw new FileNotFoundException(fileName);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            br.close();
        } catch (IOException fTopku) {}
    }
}
