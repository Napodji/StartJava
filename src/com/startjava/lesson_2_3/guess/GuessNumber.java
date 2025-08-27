package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int guessNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        generateRandomNumber();
    }

    public void start(Scanner scanner) {
        Player currentPlayer = player1;

        do {
            System.out.println("Ход игрока " + currentPlayer.getName() + ". Введите число: ");

            String input = scanner.nextLine();
            int guess = Integer.parseInt(input);

            boolean isCorrect = checkGuess(guess);

            if (isCorrect) {
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        } while (true);
    }

    private boolean checkGuess(int guess) {
        if (guess == guessNumber) {
            System.out.println("Игрок угадал число!");
            return true;
        }

        if (guess < guessNumber) {
            System.out.println("Число больше!");
        } else {
            System.out.println("Число меньше!");
        }

        return false;
    }

    private void generateRandomNumber() {
        this.guessNumber = (int) (Math.random() * 100) + 1;
    }
}
