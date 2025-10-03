package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ThresholdArrayModifier {
    private static final int CAPACITY = 15;

    public static void main(String[] args) {
        float[] numbers = generateRandomNumbers();
        int[] testIndices = {-1, 15, 0, 14};

        String[][] results = processIndices(numbers, testIndices);
        displayResults(results);
    }

    private static String[][] processIndices(float[] numbers, int[] indices) {
        String[][] results = new String[indices.length][];

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (index < 0 || index >= CAPACITY) {
                results[i] = new String[]{"ERROR", String.valueOf(index)};
            } else {
                float threshold = numbers[index];
                float[] replaced = replaceValuesAboveThreshold(numbers, threshold);
                results[i] = new String[]{
                        "SUCCESS",
                        String.valueOf(index),
                        String.valueOf(threshold),
                        formatArray(numbers),
                        formatArray(replaced)
                };
            }
        }
        return results;
    }

    private static void displayResults(String[][] results) {
        for (String[] result : results) {
            if (result[0].equals("ERROR")) {
                System.out.printf("Ошибка: значение индекса (%s) должно быть от 0 до %d%n%n",
                        result[1], CAPACITY - 1);
            } else {
                System.out.printf("Значение из ячейки [%s]: %s%n", result[1], result[2]);
                System.out.println("До обнуления:");
                System.out.println(result[3]);
                System.out.println("После обнуления:");
                System.out.println(result[4]);
                System.out.println();
            }
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

    private static float[] replaceValuesAboveThreshold(float[] source, float threshold) {
        float[] result = new float[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            result[i] = source[i] > threshold ? 0.0f : source[i];
        }
        return result;
    }

    private static String formatArray(float[] numbers) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (float number : numbers) {
            sb.append(String.format("%.3f ", number));
            count++;
            if (count % 8 == 0) {
                sb.append("\n");
            }
        }
        if (count % 8 != 0) {
            sb.append("\n");
        }
        return sb.toString();
    }
}
