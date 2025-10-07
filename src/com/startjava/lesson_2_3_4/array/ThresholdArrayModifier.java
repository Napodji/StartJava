package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class ThresholdArrayModifier {
    private static final int CAPACITY = 15;
    private static final int NUMBERS_PER_ROW = 8;

    public static void main(String[] args) {
        float[] numbers = generateRandomNumbers();
        int[] testIndices = {-1, 15, 0, 14};

        for (int index : testIndices) {
            float[] filtered = filterAboveIndexValue(numbers, index);
            printArraysWithIndexValue(numbers, filtered, index);
        }
    }

    private static float[] generateRandomNumbers() {
        Random random = new Random();
        float[] numbers = new float[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            numbers[i] = random.nextFloat();
        }
        return numbers;
    }

    private static float[] filterAboveIndexValue(float[] numbers, int index) {
        if (index < 0 || index >= CAPACITY) {
            System.out.printf("Ошибка: значение индекса (%d) должно быть от 0 до %d%n%n",
                    index, CAPACITY - 1);
            return null;
        }

        float[] filtered = Arrays.copyOf(numbers, numbers.length);

        for (int i = 0; i < CAPACITY; i++) {
            if (filtered[i] > numbers[index]) {
                filtered[i] = 0.0f;
            }
        }

        return filtered;
    }

    private static void printArraysWithIndexValue(float[] numbers, float[] filtered, int index) {
        if (filtered == null) {
            return;
        }

        System.out.printf("Значение из ячейки [%d]: %.3f%n", index, numbers[index]);
        System.out.println("До обнуления:");
        printArray(numbers);
        System.out.println("После обнуления:");
        printArray(filtered);
        System.out.println();
    }

    private static void printArray(float[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%.3f ", numbers[i]);
            if ((i + 1) % NUMBERS_PER_ROW == 0) {
                System.out.println();
            }
        }
        if (numbers.length % NUMBERS_PER_ROW != 0) {
            System.out.println();
        }
    }
}
