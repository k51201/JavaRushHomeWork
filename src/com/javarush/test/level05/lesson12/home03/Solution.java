package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        //Напишите тут ваш код
        Mouse neapolitanMouse = new Mouse("Neapolitan Mouse", 10, 6);
        Cat thomas = new Cat("Thomas", 40, "синий");
        Cat jasper = new Cat("Jasper", 40, "синий");
        Dog spike = new Dog("Spike", 50, "будка Spike");
        Dog snoop = new Dog("Snoop", 25, "будка Snoop");
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //Напишите тут ваши классы
    public static class Cat {
        String name;
        int height;
        String color;

        public Cat(String name, int height, String color) {
            this.name = name;
            this.height = height;
            this.color = color;
        }
    }

    public static class Dog {
        String name;
        int height;
        String address;

        public Dog(String name, int height, String address) {
            this.name = name;
            this.height = height;
            this.address = address;
        }
    }

}
