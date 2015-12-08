package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("C:/1/save.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setLastName("Петрович");
            user1.setCountry(User.Country.OTHER);
            user1.setBirthDate(new Date());
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter out = new PrintWriter(outputStream);

            out.println(users.size());
            for (User user : users) {
                String hasFirstName = user.getFirstName() != null ? "1" : "0";
                out.println(hasFirstName);
                if (user.getFirstName() != null)
                    out.println(user.getFirstName());

                String hasLastName = user.getLastName() != null ? "1" : "0";
                out.println(hasLastName);
                if (user.getLastName() != null)
                    out.println(user.getLastName());

                if (user.getBirthDate() != null)
                    out.println(user.getBirthDate().getTime());
                else
                    out.println();

                out.println(user.isMale());

                String hasCountry = user.getCountry() != null ? "1" : "0";
                out.println(hasCountry);
                if (user.getCountry() != null)
                    out.println(user.getCountry());
            }
            out.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            int numberOfElements = Integer.parseInt(in.readLine());
            List <User> users = new ArrayList<>(numberOfElements);
            for (int i = 0; i < numberOfElements; i++) {
                User user = new User();

                String curr = in.readLine();
                if (curr.equals("1"))
                    user.setFirstName(in.readLine());

                curr = in.readLine();
                if (curr.equals("1"))
                    user.setLastName(in.readLine());

                curr = in.readLine();
                if (!curr.equals(""))
                    user.setBirthDate(new Date(Long.parseLong(curr)));

                user.setMale(Boolean.getBoolean(in.readLine()));

                curr = in.readLine();
                if (curr.equals("1"))
                    user.setCountry(User.Country.valueOf(in.readLine()));

                users.add(user);
            }
            this.users = users;
        }
    }
}
