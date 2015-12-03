package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
 Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat {
    //Напишите тут ваш код
    String name;
    int weight;
    int age;
    String color;
    String addr;

    public void initialize(String name) {
        this.name = name;
        this.weight = 4;
        this.age = 5;
        this.color = "полосатый";
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "полосатый";
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.weight = 4;
        this.age = age;
        this.color = "полосатый";
    }

    public void initialize(int age, String color) {
        this.weight = 4;
        this.age = age;
        this.color = color;
    }

    public void initialize(int age, String color, String addr) {
        this.weight = 4;
        this.age = age;
        this.color = color;
        this.addr = addr;
    }
}
