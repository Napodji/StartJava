package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS =
              {"КЛАВИАТУРА", "ПРОЦЕССОР", "ВИДЕОКАРТА", "ПАМЯТЬ",
                      "ПРОГРАММА", "ПОЛЬЗОВАТЕЛЬ"};
    private static final String[] HANGMAN = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static final int MAX_ATTEMPTS = HANGMAN.length;
    private static final int SEPARATOR_LENGTH = 30;

    private String word;
    private char[] mask;
    private StringBuilder wrongLetters;
    private StringBuilder usedLetters;
    private int attemptsLeft;
    private int hangmanLevel;
    private Scanner scanner;

    public HangmanGame() {
        scanner = new Scanner(System.in);
        word = selectRandomWord();
        mask = createMask(word.length());
        wrongLetters = new StringBuilder();
        usedLetters = new StringBuilder();
        attemptsLeft = MAX_ATTEMPTS;
        hangmanLevel = 0;
    }

    public void start() {
        System.out.println("\nУгадай слово!");

        while (attemptsLeft > 0 && !isGuessed()) {
            printGameState();

            char letter = inputLetter();

            if (word.indexOf(letter) >= 0) {
                updateMask(letter);
                if (hangmanLevel > 0) {
                    hangmanLevel--;
                    attemptsLeft++;
                }
            } else {
                wrongLetters.append(letter).append(" ");
                hangmanLevel++;
                attemptsLeft--;
            }

            usedLetters.append(letter);
        }

        printGameResult();
    }

    private String selectRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    private char[] createMask(int length) {
        char[] newMask = new char[length];
        Arrays.fill(newMask, '*');
        return newMask;
    }

    private void printGameState() {
        printSeparator();
        printHangman();

        System.out.println("\nСлово:");
        for (char ch : mask) {
            System.out.print(ch + " ");
        }
        System.out.println();

        System.out.println("\nПопыток осталось: " + attemptsLeft);

        if (!wrongLetters.isEmpty()) {
            System.out.println("Ошибочные буквы: " + wrongLetters);
        }
    }

    private void printSeparator() {
        System.out.println("\n" + "=".repeat(SEPARATOR_LENGTH));
    }

    private void printHangman() {
        System.out.println("\nВиселица:");
        int linesToPrint = Math.min(hangmanLevel, HANGMAN.length);
        for (int i = 0; i < linesToPrint; i++) {
            System.out.println(HANGMAN[i]);
        }
    }

    private boolean isGuessed() {
        return Arrays.equals(mask, word.toCharArray());
    }

    private char inputLetter() {
        while (true) {
            System.out.print("\nВведите букву: ");
            String input = scanner.next().toUpperCase();

            if (input.length() != 1) {
                System.out.println("Ошибка: введите только одну букву");
                continue;
            }

            char letter = input.charAt(0);

            if (!isCyrillic(letter)) {
                System.out.println("Ошибка: вводите только кириллические буквы");
                continue;
            }

            if (usedLetters.indexOf(String.valueOf(letter)) >= 0) {
                System.out.println("Предупреждение: буква уже была введена");
                continue;
            }

            return letter;
        }
    }

    private boolean isCyrillic(char ch) {
        return (ch >= 'А' && ch <= 'Я') || ch == 'Ё';
    }

    private void updateMask(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                mask[i] = letter;
            }
        }
    }

    private void printGameResult() {
        printSeparator();
        printHangman();

        if (isGuessed()) {
            System.out.println("\nПоздравляем! Вы угадали слово: " + word);
        } else {
            System.out.println("\nВы проиграли! Загаданное слово было: " + word);
        }
    }
}
