package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

    }

    public static class Human {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        boolean sex;
        Human mama;
        Human papa;
        ArrayList<Human> children;

        public Human(String name, int age, boolean sex, Human mama, Human papa, ArrayList<Human> children) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mama = mama;
            this.papa = papa;
            this.children = children;
        }

        public Human() {
            this("Unknown", 0, true, null, null, new ArrayList<Human>());
        }

        public Human(String name) {
            this(name, 0, true, null, null, new ArrayList<Human>());
        }

        public Human(String name, int age) {
            this(name, age, true, null, null, new ArrayList<Human>());
        }

        public Human(String name, boolean sex) {
            this(name, 0, sex, null, null, new ArrayList<Human>());
        }

        public Human(String name, int age, boolean sex) {
            this(name, age, sex, null, null, new ArrayList<Human>());
        }

        public Human(String name, int age, boolean sex, Human mama) {
            this(name, age, sex, mama, null, new ArrayList<Human>());
        }

        public Human(String name, int age, boolean sex, ArrayList<Human> children) {
            this(name, age, sex, null, null, children);
        }

        public Human(String name, int age, boolean sex, Human mama, ArrayList<Human> children) {
            this(name, age, sex, mama, null, children);
        }

        public Human(String name, int age, boolean sex, Human mama, Human papa) {
            this(name, age, sex, mama, papa, new ArrayList<Human>());
        }
    }
}
