package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean minusOdin = false;
        int sum = 0;

        while (!minusOdin) {
            int i = Integer.parseInt(br.readLine());
            sum += i;
            if (i == -1)
                minusOdin = true;
        }
        System.out.println(sum);
    }
}
