package com.startjava.lesson_2_3_4.array;

import java.util.concurrent.TimeUnit;

public class TypewriterEffect {
    private static final int TYPING_DELAY_MS = 50;

    public static void main(String[] args) {
        String[] texts = {
                "Java - это С++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n- " +
                        "Robert Martin",
                null,
                ""
        };

        for (String text : texts) {
            printText(text);
        }
    }

    private static void printText(String text) {
        if (text == null) {
            System.out.println("Ошибка: текст не задан.\n");
            return;
        }

        if (text.isBlank()) {
            System.out.println("Ошибка: текст пустой.\n");
            return;
        }

        int wordCount = countWords(text);
        if (wordCount == 0) {
            System.out.println("Ошибка: в тексте нет слов\n");
            return;
        }

        String[] words = new String[wordCount];
        int[][] positions = new int[2][wordCount];

        extractWords(text, words, positions);

        int shortestIndex = findShortestWord(words);
        int longestIndex = findLongestWord(words);

        int[] pair = findMaxRangePair(words, positions, shortestIndex, longestIndex);
        int finalShortestIndex = pair[0];
        int finalLongestIndex = pair[1];

        String transformedText = convertMaxRangeToUpperCase(text, positions, finalShortestIndex,
                finalLongestIndex);
        printWithTypewriterEffect(transformedText);
        System.out.println("\n");
    }

    private static int countWords(String text) {
        int count = 0;
        boolean insideWord = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '+' || c == '#') {
                if (!insideWord) {
                    count++;
                    insideWord = true;
                }
            } else {
                insideWord = false;
            }
        }

        return count;
    }

    private static void extractWords(String text, String[] words, int[][] positions) {
        int wordIndex = 0;
        int start = -1;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '+' || c == '#') {
                if (start == -1) {
                    start = i;
                }
            } else {
                if (start != -1) {
                    words[wordIndex] = text.substring(start, i);
                    positions[0][wordIndex] = start;
                    positions[1][wordIndex] = i - 1;
                    wordIndex++;
                    start = -1;
                }
            }
        }

        if (start != -1) {
            words[wordIndex] = text.substring(start);
            positions[0][wordIndex] = start;
            positions[1][wordIndex] = text.length() - 1;
        }
    }

    private static int findShortestWord(String[] words) {
        int shortestIndex = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < words[shortestIndex].length()) {
                shortestIndex = i;
            }
        }
        return shortestIndex;
    }

    private static int findLongestWord(String[] words) {
        int longestIndex = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > words[longestIndex].length()) {
                longestIndex = i;
            }
        }
        return longestIndex;
    }

    private static int[] findMaxRangePair(String[] words, int[][] positions,
                                          int shortestIndex, int longestIndex) {
        if (words.length == 1) {
            return new int[]{0, 0};
        }

        int minLength = words[shortestIndex].length();
        int maxLength = words[longestIndex].length();

        int maxDistance = 0;
        int bestShortIndex = shortestIndex;
        int bestLongIndex = longestIndex;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != minLength) {
                continue;
            }

            for (int j = 0; j < words.length; j++) {
                if (words[j].length() != maxLength) {
                    continue;
                }

                int distance = Math.abs(positions[0][j] - positions[0][i]);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    bestShortIndex = i;
                    bestLongIndex = j;
                }
            }
        }

        return new int[]{bestShortIndex, bestLongIndex};
    }

    private static String convertMaxRangeToUpperCase(String text, int[][] positions,
                                                     int firstIndex, int secondIndex) {
        int startPos = Math.min(positions[0][firstIndex], positions[0][secondIndex]);
        int endPos = Math.max(positions[1][firstIndex], positions[1][secondIndex]);

        String before = text.substring(0, startPos);
        String range = text.substring(startPos, endPos + 1).toUpperCase();
        String after = text.substring(endPos + 1);

        return before + range + after;
    }

    private static void printWithTypewriterEffect(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                TimeUnit.MILLISECONDS.sleep(TYPING_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("\nОшибка:прерывание во время задержки");
                break;
            }
        }
    }
}