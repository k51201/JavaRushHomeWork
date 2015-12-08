package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            FileInputStream fin = new FileInputStream(fileName);
            load(fin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();

        for (Map.Entry<String, String> property : Solution.properties.entrySet()) {
            properties.put(property.getKey(), property.getValue());
        }

        properties.store(outputStream, "");
        outputStream.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();
        properties.load(inputStream);

        for (Map.Entry<Object, Object> property : properties.entrySet()) {
            Solution.properties.put(property.getKey().toString(), property.getValue().toString());
        }
    }
}
