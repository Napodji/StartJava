package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"КЛАВИАТУРА", "ПРОЦЕССОР", "ВИДЕОКАРТА", "ПАМЯТЬ",
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

    private HangmanGame() {
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            play(scanner);
            playAgain = askToContinue(scanner);
        }
    }

    private static void play(Scanner scanner) {
        String word = selectRandomWord();
        char[] mask = createMask(word.length());
        StringBuilder wrongLetters = new StringBuilder();
        StringBuilder usedLetters = new StringBuilder();
        int attemptsLeft = MAX_ATTEMPTS;
        int hangmanLevel = 0;

        System.out.println("\nУгадай слово!");

        while (attemptsLeft > 0 && !isWordGuessed(mask)) {
            printGameState(mask, wrongLetters.toString(), attemptsLeft, hangmanLevel);

            char letter = inputLetter(scanner, usedLetters.toString());

            if (word.indexOf(letter) >= 0) {
                updateMask(word, mask, letter);
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

        printGameResult(word, mask, hangmanLevel);
    }

    private static String selectRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    private static char[] createMask(int length) {
        char[] mask = new char[length];
        Arrays.fill(mask, '*');
        return mask;
    }

    private static boolean isWordGuessed(char[] mask) {
        return new String(mask).indexOf('*') == -1;
    }

    private static void printGameState(char[] mask, String wrongLetters, int attemptsLeft,
                                       int level) {
        printSeparator();
        printHangman(level);

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

    private static void printSeparator() {
        System.out.println("\n" + "=".repeat(SEPARATOR_LENGTH));
    }

    private static void printHangman(int level) {
        System.out.println("\nВиселица:");
        int linesToPrint = Math.min(level, HANGMAN.length);
        for (int i = 0; i < linesToPrint; i++) {
            System.out.println(HANGMAN[i]);
        }
    }

    private static char inputLetter(Scanner scanner, String usedLetters) {
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

            if (usedLetters.indexOf(letter) >= 0) {
                System.out.println("Предупреждение: буква уже была введена");
                continue;
            }

            return letter;
        }
    }

    private static boolean isCyrillic(char ch) {
        return (ch >= 'А' && ch <= 'Я') || ch == 'Ё';
    }

    private static void updateMask(String word, char[] mask, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                mask[i] = letter;
            }
        }
    }

    private static void printGameResult(String word, char[] mask, int level) {
        printSeparator();
        printHangman(level);

        if (isWordGuessed(mask)) {
            System.out.println("\nПоздравляем! Вы угадали слово: " + word);
        } else {
            System.out.println("\nВы проиграли! Загаданное слово было: " + word);
        }
    }

    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.println("\nХотите сыграть еще раз? [yes / no]:");
            String answer = scanner.next().toLowerCase();

            if (answer.equals("yes")) {
                return true;
            }

            if (answer.equals("no")) {
                System.out.println("Спасибо за игру!");
                return false;
            }

            System.out.println("Введите корректный ответ: [yes / no]");
        }
    }
}
