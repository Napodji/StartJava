package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private String name;
    private int[] numbers = new int[MAX_ATTEMPTS];
    private int attemptCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNumber(int number) {
        if (attemptCount >= MAX_ATTEMPTS) {
            System.out.println("Ошибка: превышено максимальное количество попыток");
            return;
        }

        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            System.out.printf("Число должно входить в отрезок [%d, %d]%n",
                    MIN_NUMBER, MAX_NUMBER);
            System.out.println("Попробуйте еще раз:");
            return;
        }

        numbers[attemptCount] = number;
        attemptCount++;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attemptCount);
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public boolean hasAttemptsLeft() {
        return attemptCount < MAX_ATTEMPTS;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attemptCount, 0);
        attemptCount = 0;
    }
}
