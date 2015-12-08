package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни
их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //Написать тут ваш код
        ArrayList<Human> list = new ArrayList<Human>();
        list.add(new Human("Дедушка(м)", 67, true));
        list.add(new Human("Бабушка(м)", 65, false));
        list.add(new Human("Дедушка(п)", 60, true));
        list.add(new Human("Бабушка(п)", 58, false));
        list.add(new Human("Папа", 42, true, list.get(0), list.get(1)));
        list.add(new Human("Мама", 40, false, list.get(2), list.get(3)));
        list.add(new Human("Вася", 15, true, list.get(4), list.get(5)));
        list.add(new Human("Маша", 13, false, list.get(4), list.get(5)));
        list.add(new Human("Аня", 11, false, list.get(4), list.get(5)));

        for (Human i : list)
            System.out.println(i);
    }

    public static class Human {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        Human father, mother;

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother) {
            this(name, age, sex);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
