package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(br.readLine());
        OutputStream out = new FileOutputStream(file);
        boolean exit = false;
        ArrayList<String> stringList = new ArrayList<String>();

        while (!exit) {
            String sColsoli = br.readLine();
            stringList.add(sColsoli);
            if (sColsoli.equals("exit"))
                exit = true;
        }

        for (String s : stringList) {
            for (int i = 0; i < s.length(); i++)
                out.write(s.codePointAt(i));
            out.write('\n');
        }
        out.close();
    }
}
