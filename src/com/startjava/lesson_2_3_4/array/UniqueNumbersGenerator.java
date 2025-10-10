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
            printResult(left, right, perLine, uniqueNumbers);
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

        int[] uniqueNumbers = generateUniqueNumbers(left, right, uniqueCount);
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static int[] generateUniqueNumbers(int left, int right, int count) {
        int segmentLength = right - left + 1;

        if (segmentLength < count) {
            return null;
        }

        int[] uniqueNums = new int[count];
        Random random = new Random();
        int added = 0;

        while (added < count) {
            int num = left + random.nextInt(segmentLength);

            if (!contains(uniqueNums, num, added)) {
                uniqueNums[added] = num;
                added++;
            }
        }

        return uniqueNums;
    }

    private static boolean contains(int[] array, int value, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static void printResult(int left, int right, int perLine, int[] uniqueNumbers) {
        System.out.printf("Ввод: левая граница = %d, правая = %d, чисел в строке = %d%n",
                left, right, perLine);

        if (!validateAndPrintError(left, right, perLine, uniqueNumbers)) {
            return;
        }

        System.out.print("Результат: ");
        printNumbers(uniqueNumbers, perLine);
        System.out.println();
    }

    private static boolean validateAndPrintError(int left, int right, int perLine,
                                                 int[] uniqueNumbers) {
        if (perLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n%n",
                    perLine);
            return false;
        }
        if (uniqueNumbers == null) {
            int segmentLength = right - left + 1;
            int neededLength = (int) (segmentLength * UNIQUE_PERCENTAGE);
            System.out.printf("Ошибка: длина массива должна быть > 0 (%d)%n%n", neededLength);
            return false;
        }
        return true;
    }

    private static void printNumbers(int[] numbers, int perLine) {
        int len = numbers.length;

        for (int i = 0; i < len; i++) {
            System.out.print(numbers[i]);

            if (i == len - 1) {
                System.out.println();
            } else if ((i + 1) % perLine == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
