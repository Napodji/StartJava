package com.startjava.lesson_2_3_4.array;

import java.util.OptionalLong;

public class FactorialCalculator {
    public static void main(String[] args) {
        start();
        start((int[]) null);
        start(-5);
        start(21, 0, 7);
        start(1, 20, 5, -3);
    }

    private static void start(int... numbers) {
        long[] factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);
    }

    private static long[] calculateFactorials(int[] numbers) {
        if (numbers == null) {
            System.out.println("Ошибка: передан null вместо массива чисел");
            return new long[0];
        }
        int length = numbers.length;
        if (length == 0) {
            System.out.println("Ошибка: передан пустой массив чисел");
            return new long[0];
        }

        long[] factorials = new long[length];
        for (int i = 0; i < length; i++) {
            int number = numbers[i];
            OptionalLong fact = calculateFactorial(number);
            factorials[i] = fact.orElse(-1L);
            if (factorials[i] == -1L) {
                if (number < 0) {
                    System.out.println("Ошибка: факториал " + number + "! не определён");
                } else if (number > 20) {
                    System.out.println("Ошибка: факториал " + number + "! слишком велик (максимум 20!)");
                }
            }
        }
        return factorials;
    }

    private static OptionalLong calculateFactorial(int n) {
        if (n < 0 || n > 20) {  // ← УБРАЛИ System.out.println!
            return OptionalLong.empty();
        }

        long factorial = 1L;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return OptionalLong.of(factorial);
    }

    private static void printFactorials(int[] numbers, long[] factorials) {
        if (numbers == null || factorials == null) {
            return;
        }

        int length = numbers.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int number = numbers[i];
            long factorial = factorials[i];
            if (factorial == -1L) continue;

            if (number == 0) {
                sb.append("0! = 1");
            } else if (number == 1) {
                sb.append("1! = 1");
            } else {
                sb.append(number).append("! = ").append(buildExpression(number)).append(" = ")
                        .append(factorial);
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    private static String buildExpression(int n) {
        if (n <= 1) return "";
        StringBuilder sb = new StringBuilder(n * 3);
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            if (i < n) sb.append(" * ");
        }
        return sb.toString();
    }
}
