package com.startjava.lesson_1.base;

import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1.ВЫВОД ASCII-СИМВОЛОВ");
        System.out.printf("%-8s %-10s %s\n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i < 48; i++) {
            if (i % 2 != 0) {
                System.out.printf("%4d %9c           %s\n", i, i, Character.getName(i));
            }
        }
        for (int i = 98; i <= 122; i++) {
            if (i % 2 == 0) {
                System.out.printf("%4d %9c           %s\n", i, i, Character.getName(i));
            }
        }

        System.out.println("\n2.ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
        int line = 5;
        for (int i = 0; i < line; i++) {
            System.out.print("---------- ");
            for (int j = line - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.print(" ");
            for (int j = 0; j <= i * 2; j++) {
                System.out.print("^");
            }
            System.out.println();
        }

        System.out.println("\n3.ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ");
        System.out.println("   |  2  3  4  5  6  7  8  9");
        System.out.println("---+------------------------");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int j = 2; j <= 9; j++) {
                int result = i * j;
                System.out.printf("%3d", result);
            }
            System.out.println();
        }

        System.out.println("\n4.ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        int start = 1;
        int end = 24;
        int numInLine = 5;
        int numCount = 0;
        for (int i = start; i < end; i++) {
            if (i % 2 != 0) {
                System.out.printf("%2d ", i);
                numCount++;
                if (numCount == numInLine) {
                    System.out.println();
                    numCount = 0;
                }
            }
        }
        if (numCount > 0 && numCount < numInLine) {
            for (int i = numCount; i < numInLine; i++) {
                System.out.printf("%2d ", 0);
            }
        }
        System.out.println();

        System.out.println("\n5.ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int max = num1;
        int min = num1;
        if (num2 > max) {
            max = num2;
        }
        if (num2 < min) {
            min = num2;
        }
        if (num3 > max) {
            max = num3;
        }
        if (num3 < min) {
            min = num3;
        }
        System.out.print("Числа в интервале (" + min + ", " + max + "): ");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n6.РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ");
        int originalNum = 2234321;
        int currentNum = originalNum;
        int reversed = 0;
        int twoCount = 0;
        while (currentNum > 0) {
            int digit = currentNum % 10;
            reversed = reversed * 10 + digit;
            if (digit == 2) {
                twoCount++;
            }
            currentNum /= 10;
        }
        boolean palindrome = (originalNum == reversed);
        String evenOdd = (twoCount % 2 == 0) ? "четным" : "нечетным";
        System.out.printf("%d - %s с %s (%d) количеством двоек\n",
                reversed,
                palindrome ? "палиндром" : "не палиндром",
                evenOdd,
                twoCount);

        System.out.println("\n7.ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        int luckyNum = 101002;
        int copy = luckyNum;
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                secondSum += copy % 10;
            } else {
                firstSum += copy % 10;
            }
            copy /= 10;
        }
        if (firstSum == secondSum) {
            System.out.printf("%d - счастливое число\n", luckyNum);
            System.out.printf("Сумма цифр %03d = %d\n", luckyNum % 1000, secondSum);
            System.out.printf("Сумма цифр %03d = %d\n", luckyNum / 1000, firstSum);
        } else {
            System.out.println("Вам не повезло\n");
        }

        System.out.println("\n8.ГЕНЕРАТОР ПАРОЛЯ");
        Random random = new Random();
        String password = "";
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        int minNum = 33;
        int maxNum = 127;
        for (int i = 0; i < 8; i++) {
            int ch = random.nextInt(minNum, maxNum);
            password += (char) ch;
            if (ch >= 'a' && ch <= 'z') {
                hasLower = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                hasUpper = true;
            } else if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            } else if (ch >= '!' && ch <= '/') {
                hasSpecial = true;
            }
        }
        String reliability = "Слабый";
        if (password.length() >= 8 && hasUpper && hasLower && hasSpecial) {
            reliability = "Надежный";
        } else if (password.length() >= 8 && (hasUpper || hasDigit)) {
            reliability = "Средний";
        }
        System.out.println("Пароль: " + password);
        System.out.println("Надежность: " + reliability);
    }
}
