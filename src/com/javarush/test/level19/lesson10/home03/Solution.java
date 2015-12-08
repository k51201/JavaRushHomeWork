package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try {
            BufferedReader fin = new BufferedReader(new FileReader(args[0]));

            while (fin.ready()) {
                String currLine = fin.readLine();
                String[] words = currLine.split(" ");
                int year = Integer.parseInt(words[words.length - 1]) - 1900;
                int month = Integer.parseInt(words[words.length - 2]) - 1;
                int day = Integer.parseInt(words[words.length - 3]);
                StringBuilder name = new StringBuilder();
                for (int i = 0; i < words.length - 3; i++)
                    name.append(words[i]).append(' ');
                name.deleteCharAt(name.length() - 1);
                Person currPerson = new Person(name.toString(), new Date(year, month, day));
                PEOPLE.add(currPerson);
            }
            fin.close();
        } catch (IOException fTopku) {}
    }

}
