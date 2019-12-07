package com.mariiapasichna;

public class task1 {

    /*1) Вывести в 1 строку через пробел все числа от 1 до 99 со следующими изменениями:
- если число кратно 3 то вывести вместо него Hello
- если число кратно 5 то вывести вместо него World
- если число кратно и 3 и 5 то вывести вместо него HelloWorld*/

    public static void main(String[] args) {
        int number = 0;
        for (int i = 1; i <= 99; i++) {
            number = i;
            if (number % 3 == 0 && number % 5 != 0) {
                System.out.print("Hello ");
            }
            if (number % 5 == 0 && number % 3 != 0) {
                System.out.print("World ");
            }
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.print("HelloWorld ");
            }
            if (number % 3 != 0 && number % 5 != 0) {
                System.out.print(number + " ");
            }
        }
    }
}
