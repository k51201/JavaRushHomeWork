package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
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
                if ((args.length - 1) % 3 != 0) 
                    return;
                int nEntrys = (args.length - 1) / 3;
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                for (int i = 0; i < nEntrys; i++) 
                    try {
                        Date bd = sdf.parse(args[i*3 + 3]);
                        Person createPers;
                        if (args[i*3 + 2].equals("м")) {
                            createPers = Person.createMale(args[i*3 + 1], bd);
                            allPeople.add(createPers);
                            System.out.println(allPeople.indexOf(createPers));
                        } else if (args[i*3 + 2].equals("ж")) {
                            createPers = Person.createFemale(args[i*3 + 1], bd);
                            allPeople.add(createPers);
                            System.out.println(allPeople.indexOf(createPers));
                        }
                    } catch (ParseException ignore) {}

                break;
            }

            case "-u": {
                if ((args.length - 1) % 4 != 0)
                    return;
                int nEntrys = (args.length - 1) / 4;
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                for (int i = 0; i < nEntrys; i++) {
                    Person updPers = allPeople.get(Integer.parseInt(args[i*4 + 1]));

                    updPers.setName(args[i*4 + 2]);

                    if (args[i*4 + 3].equals("м"))
                        updPers.setSex(Sex.MALE);
                    else if (args[i*4 + 3].equals("ж"))
                        updPers.setSex(Sex.FEMALE);

                    try {
                        updPers.setBirthDay(sdf.parse(args[i*4 + 4]));
                    } catch (ParseException ignore) {}
                }

                break;
            }

            case "-d": {
                int nEntrys = args.length - 1;
                for (int i = 0; i < nEntrys; i++) {
                    Person delPers = allPeople.get(Integer.parseInt(args[i + 1]));

                    delPers.setName(null);
                    delPers.setSex(null);
                    delPers.setBirthDay(null);
                }
                
                break;
            }

            case "-i": {
                int nEntrys = args.length - 1;

                for (int i = 0; i < nEntrys; i++) {
                    Person infoPers = allPeople.get(Integer.parseInt(args[i + 1]));

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
}
