package com.javarush.test.level15.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь 1 конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String. Параметр может быть "plane" или "helicopter".
3.2. Закрыть поток ввода методом close().
3.3. Если параметр равен "helicopter", то статическому объекту Flyable result присвоить объект класса Helicopter.
3.4. Если параметр равен "plane", то считать второй параметр типа int, статическому объекту Flyable result присвоить объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
*/

public class Solution {
    public static Flyable result;

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String thing;
        try {
            thing = br.readLine();
            br.close();
        } catch (IOException e) {
            thing = "";
        }

        if (thing.equals("helicopter"))
            result = new Helicopter();
        else if (thing.equals("plane")) {
            br = new BufferedReader(new InputStreamReader(System.in));
            int passengers;
            try {
                passengers = Integer.parseInt(br.readLine());
                br.close();
            } catch (Exception e) {
                passengers = 0;
            }
            result = new Plane(passengers);
        }
    }
}
