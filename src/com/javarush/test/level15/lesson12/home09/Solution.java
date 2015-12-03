package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Ввод
        String lnk = "";
        try {
            lnk = br.readLine();
        } catch (IOException e) {
            lnk = "";
        }

        List<String> parList = new ArrayList<String>();
        String parStr = lnk.substring(lnk.indexOf('?') + 1);
        List<String> objValues = new ArrayList<String>();

        // Удаление лишних символов
        for (int i = 0; i < parStr.length(); i++)
            if (parStr.charAt(i) == '&' || parStr.charAt(i) == '?')
                if (parStr.charAt(i) == '?' || i < (parStr.length() - 1) && parStr.charAt(i + 1) == '&') {
                    parStr = parStr.substring(0, i) + parStr.substring(i + 1);
                    i--;
                }

        // Добыча параметров и значений obj, если имеются
        boolean endOfPars = false;
        int beginPar = 0, nextPar;
        while (!endOfPars) {
            nextPar = parStr.indexOf('&', beginPar);
            if (nextPar == -1)
                nextPar = parStr.length();

            String param = parStr.substring(beginPar, nextPar);

            int eq = param.indexOf('=');
            if (eq != -1) {
                if (param.startsWith("obj="))
                    objValues.add(param.substring(eq + 1));
                param = param.substring(0, eq);
            }

            parList.add(param);

            beginPar = parStr.indexOf('&', nextPar) + 1;
            if (beginPar == 0)
                endOfPars = true;
        }

        // Вывод
        for (String param : parList)
            System.out.print(param + " ");
        System.out.println();
        for (String objVal : objValues)
            try {
                alert(new Double(objVal));
            } catch (NumberFormatException e) {
                alert(objVal);
            }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
