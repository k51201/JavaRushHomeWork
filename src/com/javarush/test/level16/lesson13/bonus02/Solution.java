package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new LoopThread());
        threads.add(new InterruptedThread());
        threads.add(new HurrayThread());
        threads.add(new MessageThread());
        threads.add(new ReadDigThread());
    }

    static class LoopThread extends Thread {
        @Override
        public void run() {
            while (true) {/*NOP*/}
        }
    }

    static class InterruptedThread extends Thread {
        @Override
        public void run() {
            try{
                while(!isInterrupted()) {/*NOP*/}
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    static class HurrayThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignore) {/*NOP*/}
                System.out.println("Ура");
            }
        }
    }

    static class MessageThread extends Thread implements Message {

        @Override
        public void run() {
            while (!isInterrupted()) {/*NOP*/}
        }

        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException ignore) {/*NOP*/}
        }
    }

    static class ReadDigThread extends Thread {

        @Override
        public void run() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            String number = "";
            do {
                try {
                    number = br.readLine();
                    sum += Integer.parseInt(number);
                } catch (IOException ignore) {/*NOP*/
                } catch (NumberFormatException ignore) {/*NOP*/}
            } while (!number.equals("N"));
            System.out.println(sum);
        }
    }
}
