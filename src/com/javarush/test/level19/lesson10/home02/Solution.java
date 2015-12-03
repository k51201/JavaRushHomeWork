package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
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

    }
}
