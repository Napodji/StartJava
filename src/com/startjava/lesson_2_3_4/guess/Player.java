package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int MAX_ATTEMPTS = 10;

    private String name;
    private int[] numbers = new int[MAX_ATTEMPTS];
    private int attemptCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
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
