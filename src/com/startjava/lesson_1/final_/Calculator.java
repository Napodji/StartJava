package com.startjava.lesson_1.final_;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.println("Введите операцию (+, -, *, /, ^, %): ");
        char operation = scanner.next().charAt(0);
        System.out.println("Введите второе число: ");
        int b = scanner.nextInt();
        long result = 0;
        if (operation == '+') {
            result = a + b;
        } else if (operation == '-') {
            result = a - b;
        } else if (operation == '*') {
            result = a * b;
        } else if (operation == '/') {
            result = a / b;
        } else if (operation == '^') {
            result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }
        } else {
            result = a % b;
        }
        System.out.println(a + " " + operation + " " + b + " = " + result);
    }
}
