package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ThresholdArrayModifier {
    private static final int capacity = 15;

    public static void main(String[] args) {
        float[] numbers = generateRandomNumbers();
        displayArray("Исходный массив:", numbers);

        int[] testIndices = {-1, 15, 0, 14};
        processThresholds(numbers, testIndices);
    }

    private static void processThresholds(float[] numbers, int[] indicesToCheck) {
        for (int index : indicesToCheck) {
            if (index < 0 || index >= capacity) {
                System.out.printf("Ошибка: введен некорректный индекс %d. Допустимый диапазон: 0 - %d%n", index, capacity - 1);
                continue;
            }
            float threshold = numbers[index];
            System.out.printf("Значение порога из ячейки с индексом %d: %.3f%n", index, threshold);

            float[] processed = replaceValuesAboveThreshold(numbers, threshold);
            displayArray("Обработанный массив:", processed);
        }
    }

    private static float[] generateRandomNumbers() {
        Random random = new Random();
        float[] numbers = new float[capacity];
        for (int i = 0; i < capacity; i++) {
            numbers[i] = random.nextFloat();
        }
        return numbers;
    }

    private static float[] replaceValuesAboveThreshold(float[] source, float threshold) {
        float[] result = new float[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = source[i] > threshold ? 0.0f : source[i];
        }
        return result;
    }

    private static void displayArray(String header, float[] numbers) {
        System.out.println(header);
        int count = 0;
        for (float number : numbers) {
            System.out.printf("%.3f ", number);
            count++;
            if (count % 8 == 0) {
                System.out.println();
            }
        }
        if (count % 8 != 0) {
            System.out.println();
        }
    }
}
