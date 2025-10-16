package com.startjava.lesson_2_3_4.array;

import java.util.concurrent.TimeUnit;

public class TypewriterEffect {
    private static final int TYPING_DELAY_MS = 50;

    public static void main(String[] args) {
        String[] texts = {
                "Java - это С++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                        "- Robert Martin",
                null,
                ""
        };

        for (String text : texts) {
            String result = highlightExtremeWords(text);
            if (result != null) {
                type(result);
            }
        }
    }

    private static String highlightExtremeWords(String originalText) {
        if (originalText == null) {
            System.out.println("Ошибка: текст не задан.");
            return null;
        }

        if (originalText.isBlank()) {
            System.out.println("Ошибка: текст пустой.");
            return null;
        }

        String[] words = originalText.replaceAll("\\p{P}", "").split("\\s+");

        if (words.length == 0) {
            System.out.println("Ошибка: в тексте нет слов");
            return null;
        }

        int[] starts = new int[originalText.length()];
        int[] ends = new int[originalText.length()];

        int wordCount = extractWordPositions(originalText, words, starts, ends);

        int[] extremeIndices = findExtremeWordIndices(words, wordCount);
        int shortestIndex = extremeIndices[0];
        int longestIndex = extremeIndices[1];

        return toUpperCaseRange(originalText, starts, ends, shortestIndex, longestIndex);
    }

    private static int extractWordPositions(String originalText, String[] words,
                                            int[] starts, int[] ends) {
        int wordIndex = 0;
        int start = -1;

        for (int i = 0; i < originalText.length(); i++) {
            char c = originalText.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '+' || c == '#') {
                if (start == -1) {
                    start = i;
                }
            } else {
                if (start != -1) {
                    starts[wordIndex] = start;
                    ends[wordIndex] = i - 1;
                    wordIndex++;
                    start = -1;
                }
            }
        }

        if (start != -1) {
            starts[wordIndex] = start;
            ends[wordIndex] = originalText.length() - 1;
            wordIndex++;
        }

        return wordIndex;
    }

    private static int[] findExtremeWordIndices(String[] words, int wordCount) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordCount; i++) {
            if (words[i].length() < words[shortestIndex].length()) {
                shortestIndex = i;
            }

            if (words[i].length() > words[longestIndex].length()) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    private static String toUpperCaseRange(String originalText, int[] starts, int[] ends,
                                           int firstIndex, int secondIndex) {
        int startPos = Math.min(starts[firstIndex], starts[secondIndex]);
        int endPos = Math.max(ends[firstIndex], ends[secondIndex]);

        String before = originalText.substring(0, startPos);
        String range = originalText.substring(startPos, endPos + 1).toUpperCase();
        String after = originalText.substring(endPos + 1);

        return before + range + after;
    }

    private static void type(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                TimeUnit.MILLISECONDS.sleep(TYPING_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("\nОшибка: прерывание во время задержки");
                break;
            }
        }
        System.out.println("\n");
    }
}
