package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new NullPointerException());
        exceptions.add(new NoSuchElementException());
        exceptions.add(new ReflectiveOperationException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new UnsupportedOperationException());
        exceptions.add(new IllegalStateException());
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new StringIndexOutOfBoundsException());
    }
}
