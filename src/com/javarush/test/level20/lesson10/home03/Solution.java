package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File obf = new File("/home/vampa/object_file");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(obf));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(obf));

        Solution soWhat = new Solution();
        B a0 = soWhat.new B("B");
        System.out.println(a0);

        oos.writeObject(a0);
        oos.close();
        Object a1 = ois.readObject();
        ois.close();

        System.out.println(a1);

        if (a1 instanceof B) {
            System.out.println("instance of B - checked");
        } else {
            System.out.println("instance of B - fail");
        }
    }

    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }

        protected A() {
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            String name = this.name;
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            this.name = (String) in.readObject();
        }

        @Override
        public String toString() {
            return super.toString() + ' ' + this.name;
        }
    }
}
