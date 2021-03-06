package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> zarplata = new TreeMap<>();

        try {
            BufferedReader fin = new BufferedReader(new FileReader(args[0]));

            while (fin.ready()) {
                String currLine = fin.readLine();
                int split = currLine.lastIndexOf(' ');

                if (split > 0) {
                    String currName = currLine.substring(0, split);
                    Double currEntry = Double.parseDouble(currLine.substring(split + 1));

                    if (zarplata.containsKey(currName)) {
                        currEntry += zarplata.get(currName);
                        zarplata.put(currName, currEntry);
                    } else
                        zarplata.put(currName, currEntry);
                }
            }

            fin.close();
        } catch (IOException naxep) {}

        for (Map.Entry<String, Double> entry : zarplata.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
