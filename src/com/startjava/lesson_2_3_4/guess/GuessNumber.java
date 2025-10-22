package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private Player player1;
    private Player player2;
    private int guessNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start(Scanner scanner) {
        generateRandomNumber();
        player1.clear();
        player2.clear();
        System.out.println("Игра началась! У каждого игрока по " + MAX_ATTEMPTS + " попыток\n");

        Player currentPlayer = player1;
        int totalAttempts = 0;

        while (totalAttempts < MAX_ATTEMPTS * 2) {
            if (!currentPlayer.hasAttemptsLeft()) {
                System.out.println("У " + currentPlayer.getName() + " закончились попытки!\n");
                currentPlayer = switchPlayer(currentPlayer);
                if (!currentPlayer.hasAttemptsLeft()) {
                    break;
                }
                continue;
            }

            System.out.println("Попытка " + (currentPlayer.getAttemptCount() + 1));
            int guess = inputNumber(scanner, currentPlayer);
            currentPlayer.setNumber(guess);
            if (checkGuess(guess, currentPlayer)) {
                break;
            }
            currentPlayer = switchPlayer(currentPlayer);
            totalAttempts++;
        }

        printResults();
    }

    private void generateRandomNumber() {
        Random random = new Random();
        guessNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
    }

    private int inputNumber(Scanner scanner, Player player) {
        while (true) {
            System.out.print("Число вводит игрок " + player.getName() + ": ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number < MIN_NUMBER || number > MAX_NUMBER) {
                    System.out.printf("Число должно входить в отрезок [%d, %d]%n",
                            MIN_NUMBER, MAX_NUMBER);
                    System.out.println("Попробуйте еще раз:");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число");
                System.out.println("Попробуйте еще раз:");
            }
        }
    }

    private boolean checkGuess(int guess, Player player) {
        if (guess == guessNumber) {
            System.out.printf("Игрок %s угадал число %d с %d-й попытки%n%n",
                    player.getName(), guessNumber, player.getAttemptCount());
            return true;
        }
        String hint = guess < guessNumber ? "больше" : "меньше";
        System.out.println("Число " + hint + "!\n");
        return false;
    }

    private Player switchPlayer(Player currentPlayer) {
        return currentPlayer == player1 ? player2 : player1;
    }

    private void printResults() {
        System.out.println("Итоги игры:");
        printPlayerNumbers(player1);
        printPlayerNumbers(player2);
    }

    private void printPlayerNumbers(Player player) {
        System.out.print("У игрока " + player.getName() + " были следующие попытки: ");
        int[] numbers = player.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
