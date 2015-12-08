package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {

    public static void main(String[] args) {
        Person vasya = new Person("Vasya", "Pupkin", 24);
        Person mamaVasi = new Person("Mama", "Vasi", 42);
        Person papaVasi = new Person("Papa", "Vasi", 44);
        Person spinogryz = new Person("Spinogryz", "Vasilich", 4);
        Person neposeda = new Person("Neposeda", "Vasilishna", 2);
        List<Person> children = new ArrayList<>();
        children.add(spinogryz);
        children.add(neposeda);

        vasya.setMother(mamaVasi);
        vasya.setFather(papaVasi);
        vasya.setChildren(children);

        try {
            File tempFile = File.createTempFile("020703", null);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile));
            out.writeObject(vasya);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(tempFile));
            Person loadPerson = (Person)in.readObject();
            in.close();

            if (vasya.firstName.equals(loadPerson.firstName) && vasya.lastName.equals(loadPerson.lastName) && vasya.age == loadPerson.age)
                System.out.println("true");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            children = (List)in.readObject();
        }
    }
}
