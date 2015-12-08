package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        boolean show = false;

        while (!show) {
            String in = br.readLine();
            if (in.equals("сумма")) {
                System.out.println(sum);
                show = true;
            } else
                sum += Integer.parseInt(in);
        }
    }
}
