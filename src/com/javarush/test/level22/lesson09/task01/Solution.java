package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fin = new BufferedReader(new FileReader(cin.readLine()));
        cin.close();

        ArrayList<String> words = new ArrayList<>();
        while (fin.ready()) {
            String currLine = fin.readLine();
            String[] currWords = currLine.split(" ");
            Collections.addAll(words, currWords);
        }
        fin.close();

        while (!words.isEmpty()) {
            String word = words.get(0);
            String reversed = new StringBuilder(word).reverse().toString();
            int reversedIndex = words.lastIndexOf(reversed);
            if (0 < reversedIndex) {
                result.add(new Pair(word, reversed));
                words.remove(reversedIndex);
            }
            words.remove(0);
        }

        for (Pair pair : result)
            System.out.println(pair);
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
