package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
public class Solution implements Serializable {

    private Map<String, String> m = new HashMap<>();

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("/home/vampa/object_file");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        System.out.println(solution.getMap());
        System.out.println(solution.size());
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("/home/vampa/object_file");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    public Map<String, String> getMap() {
        return m;
    }

    public int size() {
        return m.size();
    }
}
