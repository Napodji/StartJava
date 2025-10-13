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
            String result = transformText(text);
            printWithTypewriterEffect(result);
        }
    }

    private static String transformText(String text) {
        if (text == null) {
            return "Ошибка: текст не задан.";
        }

        if (text.isBlank()) {
            return "Ошибка: текст пустой.";
        }

        int wordCount = countWords(text);
        if (wordCount == 0) {
            return "Ошибка: в тексте нет слов";
        }

        String[] words = new String[wordCount];
        int[] starts = new int[wordCount];
        int[] ends = new int[wordCount];

        extractWords(text, words, starts, ends);

        int shortestIndex = findShortestWord(words);
        int longestIndex = findLongestWord(words);

        int[] pair = findMaxRangePair(words, starts, shortestIndex, longestIndex);
        int finalShortestIndex = pair[0];
        int finalLongestIndex = pair[1];

        return convertMaxRangeToUpperCase(text, starts, ends, finalShortestIndex,
                finalLongestIndex);
    }

    private static void printWithTypewriterEffect(String text) {
        printText(text);
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

    private static void extractWords(String text, String[] words, int[] starts, int[] ends) {
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
                    starts[wordIndex] = start;
                    ends[wordIndex] = i - 1;
                    wordIndex++;
                    start = -1;
                }
            }
        }

        if (start != -1) {
            words[wordIndex] = text.substring(start);
            starts[wordIndex] = start;
            ends[wordIndex] = text.length() - 1;
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

    private static int[] findMaxRangePair(String[] words, int[] starts,
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

                int distance = Math.abs(starts[j] - starts[i]);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    bestShortIndex = i;
                    bestLongIndex = j;
                }
            }
        }

        return new int[]{bestShortIndex, bestLongIndex};
    }

    private static String convertMaxRangeToUpperCase(String text, int[] starts, int[] ends,
                                                     int firstIndex, int secondIndex) {
        int startPos = Math.min(starts[firstIndex], starts[secondIndex]);
        int endPos = Math.max(ends[firstIndex], ends[secondIndex]);

        String before = text.substring(0, startPos);
        String range = text.substring(startPos, endPos + 1).toUpperCase();
        String after = text.substring(endPos + 1);

        return before + range + after;
    }

    private static void printText(String text) {
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
    }
}
