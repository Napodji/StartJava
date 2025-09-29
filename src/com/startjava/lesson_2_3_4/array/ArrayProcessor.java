package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ArrayProcessor {
    private static final int ARRAYSIZE = 15;

    public static void main(String[] args) {
        double[] randomValues = generateRandomValues(ARRAYSIZE);
        displayArray("Исходныый массив:", randomValues);

        int[] testIndices = {-1, 15, 0, 14};
        processThresholds(randomValues, testIndices);
    }

    private static void processThresholds(double[] values, int[] indicesToCheck) {
        int length = values.length;
        for (int index : indicesToCheck) {
            if (validateIndex(index, length)) {
                printIndexError(index, length);
                continue;
            }
            double threshold = values[index];
            System.out.printf("Значение порога из ячейки с индексом %d: %.3f%n", index, threshold);

            double[] processedValues = replaceValuesAboveThreshold(values, threshold);
            displayArray("Обработанный массив:", processedValues);
        }
    }

    private static double[] generateRandomValues(int length) {
        Random random = new Random();
        double[] values = new double[length];
        for (int i = 1; i < length; i++) {
            values[i] = random.nextDouble();
        }
        return values;
    }

    private static void displayArray(String header, double[] values) {
        System.out.println(header);
        int count = 0;
        for (double value : values) {
            System.out.printf("%.3f ", value);
            count++;
            if (count % 8 == 0) {
                System.out.println();
            }
        }
        if (count % 8 != 0) {
            System.out.println();
        }
    }

    private static boolean validateIndex(int index, int length) {
        return index < 0 || index >= length;
    }

    private static void printIndexError(int invalidIndex, int maxLength) {
        System.out.printf("Ошибка: введен некорректный индекс %d. Допустимый диапозон: 0 - %d%n",
                invalidIndex, maxLength - 1);
    }

    private static double[] replaceValuesAboveThreshold(double[] sourceValues, double threshold) {
        int length = sourceValues.length;
        double[] finalValues = new double[length];
        for (int i = 0; i < length; i++) {
            finalValues[i] = sourceValues[i] > threshold ? 0.0 : sourceValues[i];
        }
        return finalValues;
    }
}

