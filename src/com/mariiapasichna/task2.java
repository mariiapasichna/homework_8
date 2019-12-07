package com.mariiapasichna;

public class task2 {
    /*2) Написать метод.
Входящий параметр:
Строка со словами разделенными пробелом которые состоят из больших и маленьких букв.
Метод должен вернуть ту же строку в которой первая буква в каждом слове большая, а остальные маленькие*/

    public static void main(String[] args) {
        String s = "hello world hELLO WORLD";
        StringBuilder s1 = getStringBuilder(s);
        System.out.println(s1);
    }

    private static StringBuilder getStringBuilder(String s) {
        StringBuilder s1 = new StringBuilder(s);
        s1.setCharAt(0, Character.toUpperCase(s.charAt(0)));
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (ch == ' ') {
                s1.setCharAt(i + 1, Character.toUpperCase(s.charAt(i + 1)));
            }
        }
        return s1;
    }
}
