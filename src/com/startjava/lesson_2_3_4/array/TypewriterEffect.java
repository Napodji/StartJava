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

        String[] words = originalText.replaceAll("\\p{P}", "").split("\\s+");

        if (words.length == 0) {
            System.out.println("Ошибка: в тексте нет слов");
            return null;
        }

        int[] extremeIndices = findExtremeWordIndices(words);
        int shortestIndex = extremeIndices[0];
        int longestIndex = extremeIndices[1];

        return toUpperCaseBetweenWords(originalText, words[shortestIndex],
                words[longestIndex]);
    }

    private static int[] findExtremeWordIndices(String[] words) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < words.length; i++) {
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

    private static String toUpperCaseBetweenWords(String originalText, String firstWord,
                                                  String secondWord) {
        int firstPos = findWholeWordPosition(originalText, firstWord);
        int secondPos = findWholeWordPosition(originalText, secondWord);

        if (firstPos == -1 || secondPos == -1) {
            return originalText;
        }

        int startPos = Math.min(firstPos, secondPos);
        int endPos = Math.max(firstPos + firstWord.length(),
                secondPos + secondWord.length());

        return originalText.substring(0, startPos) +
                originalText.substring(startPos, endPos).toUpperCase() +
                originalText.substring(endPos);
    }

    private static int findWholeWordPosition(String text, String word) {
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();
        int pos = 0;

        while ((pos = lowerText.indexOf(lowerWord, pos)) != -1) {
            boolean validBefore = pos == 0 || !Character.isLetter(text.charAt(pos - 1));
            int endPos = pos + word.length();
            boolean validAfter = endPos >= text.length() || !Character.isLetter(text.charAt(endPos));

            if (validBefore && validAfter) {
                return pos;
            }
            pos++;
        }
        return -1;
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
