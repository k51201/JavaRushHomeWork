package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());

        if (n1 >= n2 && n1 >= n3) {
            System.out.println(n1);
            if (n2 >= n3) {
                System.out.println(n2);
                System.out.println(n3);
            } else {
                System.out.println(n3);
                System.out.println(n2);
            }
        } else if (n2 >= n1 && n2 >= n3) {
            System.out.println(n2);
            if (n1 >= n3) {
                System.out.println(n1);
                System.out.println(n3);
            } else {
                System.out.println(n3);
                System.out.println(n1);
            }
        } else {
            System.out.println(n3);
            if (n1 >= n2) {
                System.out.println(n1);
                System.out.println(n2);
            }
            else {
                System.out.println(n2);
                System.out.println(n1);
            }
        }
    }
}
