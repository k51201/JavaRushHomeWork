package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog {
    String name;
    int rost;
    String color;

    public Dog(String name) {
        this.name = name;
        this.rost = 30;
        this.color = "пятнистый";
    }

    public Dog(String name, int rost) {
        this.name = name;
        this.rost = rost;
        this.color = "пятнистый";
    }

    public Dog(String name, int rost, String color) {
        this.name = name;
        this.rost = rost;
        this.color = color;
    }
}
