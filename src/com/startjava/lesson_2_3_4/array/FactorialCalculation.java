package com.startjava.lesson_2_3_4.array;

import java.util.OptionalLong;

public class FactorialCalculation {
    public static void main(String[] args) {
        calculateAndPrint();
        calculateAndPrint((int[]) null);
        calculateAndPrint(-5);
        calculateAndPrint(21, 0, 7);
        calculateAndPrint(1, 20, 5, -3);
    }

    private static void calculateAndPrint(int... inputs) {
        long[] results = validateCheck(inputs);
        printResults(inputs, results);
    }

    private static long[] validateCheck(int[] inputs) {
        if (inputs == null) {
            System.out.println("Ошибка: передан null вместо массива чисел");
            return new long[0];
        }
        int length = inputs.length;
        if (length == 0) {
            System.out.println("Ошибка: передан пустой массив чисел");
            return new long[0];
        }

        long[] results = new long[length];
        for (int i = 0; i < length; i++) {
            int n = inputs[i];
            OptionalLong fact = factorialLong(n);
            results[i] = fact.orElse(-1);
            if (results[i] == -1) {
                if (n < 0) {
                    System.out.println("Ошибка: факториал " + n + "! не определен");
                } else if (n > 20) {
                    System.out.println("Ошибка: факториал " + n + "! слишком велик (максимум 20!)");
                }
            }
        }
        return results;
    }

    private static void printResults(int[] inputs, long[] results) {
        if (inputs == null || results == null) return;
        int length = inputs.length;
        for (int i = 0; i < length; i++) {
            int n = inputs[i];
            long value = results[i];
            if (value == -1) {
                continue;
            }
            String line = (n == 0) ? "0! = 1"
                    : (n == 1) ? "1! = 1"
                    : n + "! = " + buildExpression(n) + " = " + value;
            System.out.println(line);
        }
    }

    private static OptionalLong factorialLong(int n) {
        if (n < 0 || n > 20) return OptionalLong.empty();
        long fact = 1L;
        for (int k = 2; k <= n; k++) {
            fact *= k;
        }
        return OptionalLong.of(fact);
    }

    private static String buildExpression(int n) {
        if (n <= 1) return "";
        int length = n;
        StringBuilder sb = new StringBuilder(length * 3);
        for (int i = 1; i <= length; i++) {
            sb.append(i);
            if (i < length) sb.append(" * ");
        }
        return sb.toString();
    }
}
