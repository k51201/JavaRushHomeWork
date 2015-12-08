package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if (b > a) {
            int buf = b;
            b = a;
            a = buf;
        }

        int nod = 1;
        for (int i = b; i > nod; i--)
            if ((a % i == 0) && (b % i == 0))
                nod = i;
        System.out.println(nod);
    }
}
