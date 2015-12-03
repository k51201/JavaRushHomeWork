package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //Написать тут ваш код
        ArrayList<Human> humans = new ArrayList<Human>();
        humans.add(new Human("Вася", true, 15));
        humans.add(new Human("Маша", false, 13));
        humans.add(new Human("Аня", false, 11));
        ArrayList<Human> childrenMamaAndPapa = new ArrayList<Human>(humans);

        humans.add(new Human("Папа", true, 42, childrenMamaAndPapa));
        humans.add(new Human("Мама", false, 40, childrenMamaAndPapa));


        humans.add(new Human("Дедушка(м)", true, 67, new ArrayList<Human>()));
        humans.get(5).children.add(humans.get(4));
        humans.add(new Human("Бабушка(м)", false, 65, humans.get(5).children));

        humans.add(new Human("Дедушка(п)", true, 60, new ArrayList<Human>()));
        humans.get(7).children.add(humans.get(3));
        humans.add(new Human("Бабушка(п)", false, 58, humans.get(7).children));

        for (Human human : humans)
            System.out.println(human);
    }

    public static class Human {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this(name, sex, age);
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
