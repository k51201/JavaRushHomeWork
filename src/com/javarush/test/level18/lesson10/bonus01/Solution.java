package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        switch (args[0]) {
            case "-e":
                try {
                    FileInputStream fin = new FileInputStream(args[1]);
                    FileOutputStream fout = new FileOutputStream(args[2]);

                    while (fin.available() > 0) {
                        byte curr = (byte) ~(fin.read());
                        fout.write(curr);
                    }
                    fout.close();
                    fin.close();
                } catch (IOException e) {}
                break;
            case "-d":
                try {
                    FileInputStream fin = new FileInputStream(args[1]);
                    FileOutputStream fout = new FileOutputStream(args[2]);

                    while (fin.available() > 0) {
                        byte curr = (byte) ~(fin.read());
                        fout.write(curr);
                    }
                    fout.close();
                    fin.close();
                } catch (IOException e) {}
        }
    }

}
