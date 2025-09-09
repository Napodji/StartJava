package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public long calculate(long a, char operation, long b) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено!");
                    return 0;
                }
                return a / b;
            case '^':
                if (b == 0) return 1;

                long result = 1;
                long exponent = Math.abs(b);

                for (int i = 0; i < exponent; i++) {
                    result *= a;
                }

                return b < 0 ? 1 / result : result;
            case '%':
                if (b == 0) {
                    System.out.println("Деление на ноль запрещено!");
                    return 0;
                }
                return a % b;
            default:
                System.out.println("Операция '" + operation + "' не поддерживается!");
                return 0;
        }
    }
}

