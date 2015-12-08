package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            if(args.length == 0)
                throw new IllegalArgumentException();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fin = new FileReader(br.readLine());
            br.close();
            BufferedReader finBuf = new BufferedReader(fin);

            String res;

            while((res = finBuf.readLine()) != null){
                if(res.startsWith(args[0] + " ")){
                    System.out.println(res);
                    break;
                }
            }

            fin.close();
            finBuf.close();
        } catch (IOException e) {}
    }
}
