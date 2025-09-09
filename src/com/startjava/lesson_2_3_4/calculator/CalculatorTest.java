package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String continuation = "YES";

        while (continuation.equals("YES")) {
            System.out.println("Введите первое число: ");
            long a = scanner.nextLong();

            System.out.println("Введите знак операции (+, -, *, /, ^, %): ");
            char operation = scanner.next().charAt(0);

            System.out.println("Введите второе число: ");
            long b = scanner.nextLong();

            long result = calculator.calculate(a, operation, b);

            if (!(operation == '/' && b == 0)) {
                System.out.println(a + " " + operation + " " + b + " = " + result);
            }

            do {
                System.out.println("Хотите продолжить вычисления? [YES/NO]: ");
                continuation = scanner.next().toUpperCase();
            } while (!continuation.equals("YES") && !continuation.equals("NO"));
        }

        scanner.close();
    }
}

