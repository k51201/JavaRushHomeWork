package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обученияJava....hj...") + '|');
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty())
            throw new TooShortStringException();

        int beginIndex = string.indexOf(' ');

        int endIndex = beginIndex;
        for (int i = 0; i < 3; i++) {
            if (endIndex < 0)
                throw new TooShortStringException();
            endIndex = string.indexOf(' ', ++endIndex);
        }
        if (0 < endIndex)
            while (Character.isLetterOrDigit(string.charAt(endIndex + 1)) && endIndex <= string.length())
                endIndex++;
        else
            throw new TooShortStringException();

        return string.substring(++beginIndex, ++endIndex);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
