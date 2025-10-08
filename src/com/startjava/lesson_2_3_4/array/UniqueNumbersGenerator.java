package com.startjava.lesson_2_3_4.array;

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

            int[] uniqueNumbers = generateAndSortUniqueNumbers(left, right);
            printResult(left, right, perLine, uniqueNumbers);
        }
    }

    private static int[] generateAndSortUniqueNumbers(int left, int right) {
        if (left > right) {
            return null;
        }

        int segmentLength = calculateSegmentLength(left, right);
        int uniqueCount = (int) (segmentLength * UNIQUE_PERCENTAGE);

        if (uniqueCount < 1) {
            return null;
        }

        int[] uniqueNumbers = generateUniqueNumbers(left, right, uniqueCount);
        sortAscending(uniqueNumbers);
        return uniqueNumbers;
    }

    private static int calculateSegmentLength(int left, int right) {
        return right - left + 1;
    }

    private static int[] generateUniqueNumbers(int left, int right, int count) {
        int segmentLength = calculateSegmentLength(left, right);
        int[] consecutiveNumbers = new int[segmentLength];

        for (int i = 0; i < segmentLength; i++) {
            consecutiveNumbers[i] = left + i;
        }

        shuffle(consecutiveNumbers);

        int[] uniqueNumbers = new int[count];
        System.arraycopy(consecutiveNumbers, 0, uniqueNumbers, 0, count);
        return uniqueNumbers;
    }

    private static void shuffle(int[] numbers) {
        Random random = new Random();
        int len = numbers.length;

        for (int i = len - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            swap(numbers, i, randomIndex);
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static void sortAscending(int[] numbers) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (numbers[j] < numbers[i]) {
                    swap(numbers, i, j);
                }
            }
        }
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
            int neededLength = (int) (calculateSegmentLength(left, right) * UNIQUE_PERCENTAGE);
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
