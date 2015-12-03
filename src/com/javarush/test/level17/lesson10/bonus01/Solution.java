package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length < 2)
            return;

        switch (args[0]) {

            case "-c": {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                try {
                    Date bd = sdf.parse(args[3]);
                    Person createPers;
                    if (args[2].equals("м")) {
                        createPers = Person.createMale(args[1], bd);
                        allPeople.add(createPers);
                        System.out.println(allPeople.indexOf(createPers));
                    } else if (args[2].equals("ж")) {
                        createPers = Person.createFemale(args[1], bd);
                        allPeople.add(createPers);
                        System.out.println(allPeople.indexOf(createPers));
                    }
                } catch (ParseException ignore) {}

                break;
            }

            case "-u": {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Person updPers = allPeople.get(Integer.parseInt(args[1]));

                updPers.setName(args[2]);

                if (args[3].equals("м"))
                    updPers.setSex(Sex.MALE);
                else if (args[3].equals("ж"))
                    updPers.setSex(Sex.FEMALE);

                try {
                    updPers.setBirthDay(sdf.parse(args[4]));
                } catch (ParseException ignore) {}

                break;
            }

            case "-d": {
                if (args.length > 2)
                    return;
                Person delPers = allPeople.get(Integer.parseInt(args[1]));

                delPers.setName(null);
                delPers.setSex(null);
                delPers.setBirthDay(null);

                break;
            }

            case "-i": {
                if (args.length > 2)
                    return;
                Person infoPers = allPeople.get(Integer.parseInt(args[1]));

                if ((infoPers.getName() != null) && (infoPers.getSex() != null) && (infoPers.getBirthDay() != null)) {
                    char cSex = ' ';
                    if (infoPers.getSex() == Sex.MALE)
                        cSex = 'м';
                    else if (infoPers.getSex() == Sex.FEMALE)
                        cSex = 'ж';
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.println(infoPers.getName() + " " + cSex + " " + sdf.format(infoPers.getBirthDay()));
                }
            }

        }

    }
}
