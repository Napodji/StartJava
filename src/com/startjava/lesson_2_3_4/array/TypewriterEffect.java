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
            if (result != null) {
                type(result);
            }
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

        int[] extremeIndices = findExtremeWordIndices(words, originalText);
        int shortestIndex = extremeIndices[0];
        int longestIndex = extremeIndices[1];

        return toUpperCaseBetweenWords(originalText, words[shortestIndex],
                words[longestIndex]);
    }

    private static int[] findExtremeWordIndices(String[] words, String originalText) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < words.length; i++) {
            if (!isWholeWord(words[i], originalText)) {
                continue;
            }

            if (words[i].length() < words[shortestIndex].length()) {
                shortestIndex = i;
            }

            if (words[i].length() > words[longestIndex].length()) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    private static boolean isWholeWord(String word, String text) {
        String lowerWord = word.toLowerCase();
        String lowerText = text.toLowerCase();
        int index = lowerText.indexOf(lowerWord);

        while (index != -1) {
            boolean validBefore = (index == 0) ||
                    !Character.isLetter(text.charAt(index - 1));
            int endIndex = index + word.length();
            boolean validAfter = (endIndex >= text.length()) ||
                    !Character.isLetter(text.charAt(endIndex));

            if (validBefore && validAfter) {
                return true;
            }

            index = lowerText.indexOf(lowerWord, index + 1);
        }

        return false;
    }

    private static String toUpperCaseBetweenWords(String originalText, String firstWord,
                                                  String secondWord) {
        int firstPos = findWordPosition(originalText, firstWord);
        int secondPos = findWordPosition(originalText, secondWord);

        if (firstPos == -1 || secondPos == -1) {
            return originalText;
        }

        int startPos = Math.min(firstPos, secondPos);
        int firstEndPos = firstPos + firstWord.length();
        int secondEndPos = secondPos + secondWord.length();
        int endPos = Math.max(firstEndPos, secondEndPos);

        String before = originalText.substring(0, startPos);
        String range = originalText.substring(startPos, endPos).toUpperCase();
        String after = originalText.substring(endPos);

        return before + range + after;
    }

    private static int findWordPosition(String text, String word) {
        String lowerWord = word.toLowerCase();
        String lowerText = text.toLowerCase();
        int index = lowerText.indexOf(lowerWord);

        while (index != -1) {
            boolean validBefore = (index == 0) ||
                    !Character.isLetter(text.charAt(index - 1));
            int endIndex = index + word.length();
            boolean validAfter = (endIndex >= text.length()) ||
                    !Character.isLetter(text.charAt(endIndex));

            if (validBefore && validAfter) {
                return index;
            }

            index = lowerText.indexOf(lowerWord, index + 1);
        }

        return -1;
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
