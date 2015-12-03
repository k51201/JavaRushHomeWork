package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(br.readLine());
        FileInputStream fileIS = new FileInputStream(file);
        OutputStream os = new BufferedOutputStream(System.out);

        while (fileIS.available() > 0)
            os.write(fileIS.read());

        fileIS.close();
        os.close();
    }
}
