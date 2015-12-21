package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        File tableFile = new File(cin.readLine());
        cin.close();

        BufferedReader fin = new BufferedReader(new FileReader(tableFile));
        List<String> lines = new ArrayList<>();
        int maxId = 0;
        while (fin.ready()) {
            String currLine = fin.readLine();
            if (!currLine.isEmpty()) {
                lines.add(currLine);
                int currId = Integer.parseInt(currLine.substring(0, 8).trim());
                if (maxId < currId)
                    maxId = currId;
            }
        }
        fin.close();

        if (args[0].equals("-c")) {
            StringBuilder newLine = new StringBuilder(50);
            String id = trimLineToSize(Integer.toString(maxId + 1), 8);
            String productName = trimLineToSize(args[1], 30);
            String price = trimLineToSize(args[2], 8);
            String quantity = trimLineToSize(args[3], 4);
            newLine.append(id).append(productName).append(price).append(quantity);
            lines.add(newLine.toString());
        }

        PrintWriter fout = new PrintWriter(tableFile);
        for (String line : lines)
            fout.println(line);
        fout.close();
    }

    private static String trimLineToSize(String line, int size) {
        String resultLine;
        if (size < line.length())
            resultLine = line.substring(0, size);
        else {
            int missingSpaces = size - line.length();
            StringBuilder lineBuffer = new StringBuilder(line);
            for (int i = 0; i < missingSpaces; i++)
                lineBuffer.append(' ');
            resultLine = lineBuffer.toString();
        }
        return resultLine;
    }
}
