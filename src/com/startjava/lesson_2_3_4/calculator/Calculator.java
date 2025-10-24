package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_PARTS_COUNT = 3;

    public double calculate(String expression) {
        if (expression == null || expression.isBlank()) {
            System.out.println("Ошибка: выражение не может быть пустым");
            return Double.NaN;
        }

        String[] parts = expression.split(" ");
        if (parts.length != EXPRESSION_PARTS_COUNT) {
            System.out.println("Ошибка: выражение должно содержать два числа и операцию");
            return Double.NaN;
        }

        if (parts[1].length() != 1) {
            System.out.println("Ошибка: операция должна быть одним символом");
            return Double.NaN;
        }

        Integer a = parseNumber(parts[0]);
        if (a == null) {
            return Double.NaN;
        }

        Integer b = parseNumber(parts[2]);
        if (b == null) {
            return Double.NaN;
        }

        char operation = parts[1].charAt(0);
        return performOperation(a, operation, b);
    }

    private Integer parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.printf("Ошибка: '%s' не является целым числом%n", str);
            return null;
        }
    }

    private double performOperation(int a, char operation, int b) {
        if ((operation == '/' || operation == '%') && b == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return Double.NaN;
        }

        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return (double) a / b;
            case '^':
                return Math.pow(a, b);
            case '%':
                return a % b;
            default:
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", operation);
                return Double.NaN;
        }
    }
}
