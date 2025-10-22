package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public double calculate(String expression) {
        String[] parts = validateExpression(expression);
        if (parts == null) {
            return Double.NaN;
        }

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        char operation = parts[1].charAt(0);

        return performOperation(a, operation, b);
    }

    private String[] validateExpression(String expression) {
        if (expression == null || expression.isBlank()) {
            System.out.println("Ошибка: выражение не может быть пустым");
            return null;
        }

        String[] parts = expression.split(" ");

        if (parts.length != 3) {
            System.out.println("Ошибка: выражение должно содержать два числа и операцию");
            return null;
        }

        if (!isInteger(parts[0])) {
            System.out.printf("Ошибка: '%s' не является целым числом%n", parts[0]);
            return null;
        }

        if (!isInteger(parts[2])) {
            System.out.printf("Ошибка: '%s' не является целым числом%n", parts[2]);
            return null;
        }

        if (parts[1].length() != 1) {
            System.out.println("Ошибка: операция должна быть одним символом");
            return null;
        }

        return parts;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", operation);
                return Double.NaN;
        }
    }
}
