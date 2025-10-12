package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersGenerator {
    private static final double UNIQUE_PERCENTAGE = 0.75;

    public static void main(String[] args) {
        int[][] testData = {
                {-30, -10, 23},
                {10, 50, 10},
                {-34, -34, 1},
                {-1, 2, -3},
                {5, -8, 2}
        };

        for (int[] test : testData) {
            int left = test[0];
            int right = test[1];
            int perLine = test[2];

            int[] uniqueNumbers = generateSortedUniqueNumbers(left, right);
            printUniqueNumbers(left, right, perLine, uniqueNumbers);
        }
    }

    private static int[] generateSortedUniqueNumbers(int left, int right) {
        if (left > right) {
            return null;
        }

        int segmentLength = right - left + 1;
        int uniqueCount = (int) (segmentLength * UNIQUE_PERCENTAGE);

        if (uniqueCount < 1) {
            return null;
        }

        int[] uniqueNumbers = new int[uniqueCount];
        Random random = new Random();
        int index = 0;

        while (index < uniqueCount) {
            int number = left + random.nextInt(segmentLength);

            if (!containsNumber(uniqueNumbers, number, index)) {
                uniqueNumbers[index] = number;
                index++;
            }
        }

        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static boolean containsNumber(int[] array, int value, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static void printUniqueNumbers(int left, int right, int perLine,
                                           int[] uniqueNumbers) {
        System.out.printf("Ввод: левая граница = %d, правая = %d, чисел в строке = %d%n",
                left, right, perLine);

        if (!isValid(left, right, perLine, uniqueNumbers)) {
            return;
        }

        System.out.println("Результат:");
        printNumbers(uniqueNumbers, perLine);
        System.out.println();
    }

    private static boolean isValid(int left, int right, int perLine,
                                   int[] uniqueNumbers) {
        if (uniqueNumbers == null) {
            int segmentLength = right - left + 1;
            int neededLength = (int) (segmentLength * UNIQUE_PERCENTAGE);
            System.out.printf("Ошибка: длина массива должна быть > 0 (%d)%n%n", neededLength);
            return false;
        }

        if (perLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n%n",
                    perLine);
            return false;
        }

        return true;
    }

    private static void printNumbers(int[] numbers, int perLine) {
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            System.out.print(numbers[i]);

            if (i == length - 1) {
                System.out.println();
            } else if ((i + 1) % perLine == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
