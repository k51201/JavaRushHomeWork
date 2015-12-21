package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            File tableFile = new File(cin.readLine());
            cin.close();

            BufferedReader fin = new BufferedReader(new FileReader(tableFile));
            Map<Integer, String> table = new HashMap<>();
            while (fin.ready()) {
                String currLine = fin.readLine();
                if (!currLine.isEmpty()) {
                    int currId = Integer.parseInt(currLine.substring(0, 8).trim());
                    table.put(currId, currLine.substring(8));
                }
            }
            fin.close();

            switch (args[0]) {
                case "-u":
                    StringBuilder newLine = new StringBuilder(50);
                    int id = Integer.parseInt(args[1]);
                    String productName = trimLineToSize(args[2], 30);
                    String price = trimLineToSize(args[3], 8);
                    String quantity = trimLineToSize(args[4], 4);
                    newLine.append(productName).append(price).append(quantity);
                    table.put(id, newLine.toString());
                    break;
                case "-d":
                    table.remove(Integer.parseInt(args[1]));
            }

            PrintWriter fout = new PrintWriter(tableFile);
            for (Map.Entry<Integer, String> tableEntry : table.entrySet()) {
                String idLine = trimLineToSize(tableEntry.getKey().toString(), 8);
                fout.println(idLine + tableEntry.getValue());
            }
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
