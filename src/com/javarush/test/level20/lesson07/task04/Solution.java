package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable{
    private transient final String pattern = "dd MMMM yyyy, EEEE";
    String string;
    private transient Date currentDate;
    private transient int temperature;
    public Solution() {
        this(0);
    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution(4));
        try {
            File tempFile = File.createTempFile("200704", null);
            ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(tempFile));

            Solution savedObject = new Solution(0);
            fout.writeObject(savedObject);
            fout.close();

            savedObject = new Solution(-2);

            ObjectInputStream fin = new ObjectInputStream(new FileInputStream(tempFile));
            Solution loadedObject = (Solution) fin.readObject();
            fin.close();

            System.out.println(savedObject.toString());
            System.out.println(loadedObject.toString());

            if (savedObject.string.equals(loadedObject.string))
                System.out.println("Bingo!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.string;
    }
}
