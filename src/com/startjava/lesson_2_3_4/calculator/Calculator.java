package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public double calculate(String expression) {
        if (expression == null || expression.isBlank()) {
            System.out.println("Ошибка: выражение не может быть пустым");
            return Double.NaN;
        }

        String[] parts = expression.split(" ");

        if (parts.length != 3) {
            System.out.println("Ошибка: выражение должно содержать два числа и операцию");
            return Double.NaN;
        }

        int a;
        int b;

        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введены некорректные числа");
            return Double.NaN;
        }

        char operation = parts[1].charAt(0);

        if (parts[1].length() != 1) {
            System.out.println("Ошибка: операция должна быть одним символом");
            return Double.NaN;
        }

        return performOperation(a, operation, b);
    }

    private double performOperation(int a, char operation, int b) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return Double.NaN;
                }
                return (double) a / b;
            case '^':
                return Math.pow(a, b);
            case '%':
                if (b == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return Double.NaN;
                }
                return a % b;
            default:
                System.out.println("Ошибка: операция '" + operation + "' не поддерживается");
                return Double.NaN;
        }
    }
}
