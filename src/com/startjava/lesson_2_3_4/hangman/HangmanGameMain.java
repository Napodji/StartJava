package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        printGameDescription();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            HangmanGame game = new HangmanGame();
            game.start();
            playAgain = askToContinue(scanner);
        }
    }

    private static void printGameDescription() {
        System.out.println("""

        ╔══════════════════════════════════════════════════╗
        ║       ДОБРО ПОЖАЛОВАТЬ В ИГРУ "ВИСЕЛИЦА"         ║
        ╚══════════════════════════════════════════════════╝
        
        ПРАВИЛА ИГРЫ:
        • Компьютер загадывает слово
        • Вы угадываете его по одной букве
        • Угаданная буква открывается во всех позициях
        • За каждую ошибку добавляется элемент виселицы
        • За каждую правильную букву виселица убирается на шаг назад
        • Попыток ограничено - угадайте слово до полной виселицы!
        ══════════════════════════════════════════════════
        """);
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
