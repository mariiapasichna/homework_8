package com.mariiapasichna;

import java.util.Arrays;
import java.util.Random;

public class task3 {

    /*3) Создать генератор паролей, который будет генерировать случайные пароли по следующим правилам:
Пароль состоит из 8 символов
В пароле допускаются только латинские большие и маленькие буквы, цифры и символ подчеркивания
Пароль обязательно должен содержать Большие и маленькие буквы и цифры*/

    public static final int SIZE = 8;
    public static void main(String[] args) {
        int positionNumber = '9' - '0' + 1;
        int positionUpperCase = 'Z' - 'A' + 1;
        int positionLowerCase = 'z' - 'a' + 1;
        int size = positionNumber + positionUpperCase + positionLowerCase + 1;
        char[] arr1 = new char[size];
        arr1[0] = '_';
        for (int i = 1; i <= positionNumber; i++) {
            for (int j = '0'; j <= '9'; i++) {
                arr1[i] = (char) j;
                j++;
            }
        }
        for (int i = positionNumber + 1; i <= positionNumber + positionUpperCase; i++) {
            for (int j = 'A'; j <= 'Z'; i++) {
                arr1[i] = (char) j;
                j++;
            }
        }
        for (int i = positionNumber + positionUpperCase + 1; i <= arr1.length; i++) {
            for (int j = 'a'; j <= 'z'; i++) {
                arr1[i] = (char) j;
                j++;
            }
        }
        char[] password = new char[SIZE];
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        do {
            for (int i = 0; i < password.length; i++) {
                int arr1Index = new Random().nextInt(arr1.length);
                password[i] = arr1[arr1Index];
                if (password[i] >= '0' && password[i] <= '9') {
                    count1++;
                }
                if (password[i] >= 'A' && password[i] <= 'Z') {
                    count2++;
                }
                if (password[i] >= 'a' && password[i] <= 'z') {
                    count3++;
                }
            }
        }
        while (count1 == 0 || count2 == 0 || count3 == 0);
        System.out.println(Arrays.toString(password));
    }
}
