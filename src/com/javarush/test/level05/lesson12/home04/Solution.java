package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.util.Calendar;

public class Solution {
    public static void main(String[] args) {
        //Напишите тут ваш код
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.DATE)+ " " + (cal.get(Calendar.MONTH) + 1) + " " + cal.get(Calendar.YEAR));
    }
}
