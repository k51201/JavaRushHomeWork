package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fin = new FileInputStream(br.readLine());
            FileOutputStream fout = new FileOutputStream(br.readLine());
            br.close();

            byte[] buf = new byte[fin.available()];
            fin.read(buf);
            fin.close();

            int spacePos = -1;
            for (int i = 0; i < buf.length; i++) {
                if ((buf[i] == ' ') || ((buf.length - 1) == i)) {
                    if ((i - spacePos) > 1) {
                        double numIn = Double.parseDouble(new String(buf, spacePos + 1, i - spacePos));
                        byte[] bytes = String.valueOf(Math.round(numIn)).getBytes();
                        fout.write(bytes);
                        if ((buf.length - 1) != i)
                            fout.write(' ');
                    }
                    spacePos = i;
                }
            }
            fout.close();
        } catch (IOException ignore) {}
    }
}
