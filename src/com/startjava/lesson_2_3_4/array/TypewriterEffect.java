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
            String result = toUpperCaseRange(text);
            type(result);
        }
    }

    private static String toUpperCaseRange(String originalText) {
        if (originalText == null) {
            System.out.println("Ошибка: текст не задан.");
            return null;
        }

        if (originalText.isBlank()) {
            System.out.println("Ошибка: текст пустой.");
            return null;
        }

        String[] words = originalText.split("\\s+");
        String[] cleanWords = new String[words.length];
        int[] positions = new int[words.length];
        int wordCount = 0;
        int searchFrom = 0;

        for (String word : words) {
            int wordPos = originalText.indexOf(word, searchFrom);
            String cleanWord = word.replaceAll("\\p{P}", "");

            if (!cleanWord.isEmpty()) {
                cleanWords[wordCount] = cleanWord;
                int leadingPunctuationLength = word.indexOf(cleanWord);
                positions[wordCount] = wordPos + leadingPunctuationLength;
                wordCount++;
            }

            searchFrom = wordPos + word.length();
        }

        if (wordCount == 0) {
            System.out.println("Ошибка: в тексте нет слов");
            return null;
        }

        int[] extremeIndices = findExtremeWordIndices(cleanWords, wordCount);
        int shortestIndex = extremeIndices[0];
        int longestIndex = extremeIndices[1];

        int startPos = Math.min(positions[shortestIndex], positions[longestIndex]);
        int endPos = Math.max(positions[shortestIndex] + cleanWords[shortestIndex].length(),
                positions[longestIndex] + cleanWords[longestIndex].length());

        return originalText.substring(0, startPos) +
                originalText.substring(startPos, endPos).toUpperCase() +
                originalText.substring(endPos);
    }

    private static int[] findExtremeWordIndices(String[] words, int count) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < count; i++) {
            if (words[i].isEmpty()) continue;

            if (words[i].length() < words[shortestIndex].length()) {
                shortestIndex = i;
            }

            if (words[i].length() > words[longestIndex].length()) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    private static void type(String text) {
        if (text == null) {
            return;
        }

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
