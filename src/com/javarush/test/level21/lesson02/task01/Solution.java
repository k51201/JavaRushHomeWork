package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[4];
        netAddress[0] = (byte) (ip[0] & mask[0]);
        netAddress[1] = (byte) (ip[1] & mask[1]);
        netAddress[2] = (byte) (ip[2] & mask[2]);
        netAddress[3] = (byte) (ip[3] & mask[3]);
        return netAddress;
    }

    public static void print(byte[] bytes) {
        byte[] bits = {1, 2, 4, 8, 16, 32, 64, (byte)128};
        for (int i = 0; i < bytes.length; i++) {
            StringBuilder binaryString = new StringBuilder(8);
            for (int j = 7; 0 <= j; j--)
                binaryString.append((bytes[i] & bits[j]) != 0 ? 1 : 0);
            System.out.print(binaryString.toString() + " ");
        }
        System.out.println();
    }
}