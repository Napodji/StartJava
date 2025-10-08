package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ThresholdArrayModifier {
    private static final int CAPACITY = 15;
    private static final int NUMBERS_PER_ROW = 8;

    public static void main(String[] args) {
        float[] original = generateRandomNumbers();
        int[] testIndices = {-1, 15, 0, 14};

        for (int index : testIndices) {
            float[] modified = filterAboveIndexValue(original, index);
            printArraysWithIndexValue(original, modified, index);
        }
    }

    private static float[] filterAboveIndexValue(float[] source, int index) {
        if (index < 0 || index >= CAPACITY) {
            System.out.printf("Ошибка: значение индекса (%d) должно быть от 0 до %d%n%n",
                    index, CAPACITY - 1);
            return null;
        }

        float threshold = source[index];
        float[] result = new float[CAPACITY];

        for (int i = 0; i < CAPACITY; i++) {
            result[i] = source[i] > threshold ? 0.0f : source[i];
        }

        return result;
    }

    private static void printArraysWithIndexValue(float[] original, float[] modified, int index) {
        if (modified == null) {
            return;
        }

        float threshold = original[index];
        System.out.printf("Значение из ячейки [%d]: %.3f%n", index, threshold);
        System.out.println("До обнуления:");
        printArray(original);
        System.out.println("После обнуления:");
        printArray(modified);
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

    private static float[] generateRandomNumbers() {
        Random random = new Random();
        float[] numbers = new float[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            numbers[i] = random.nextFloat();
        }
        return numbers;
    }
}
