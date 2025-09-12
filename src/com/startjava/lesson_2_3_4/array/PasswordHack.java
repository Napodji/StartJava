package com.startjava.lesson_2_3_4.array;

public class PasswordHack {
    public static void main(String[] args) throws InterruptedException {
        boolean result = processHacking();
        displayResult(result);
    }

    private static boolean processHacking() throws InterruptedException {
        char[] spinnerSymbols = {'-', '\\', '|', '/'};
        final int rotations = 3;

        System.out.print("Hacking...");

        for (int i = 0; i < rotations * spinnerSymbols.length; i++) {
            char symbol = spinnerSymbols[i % spinnerSymbols.length];
            System.out.print("\b" + symbol);
            Thread.sleep(150);
        }

        int number = (int) (Math.random() * 100);
        System.out.print("\b");

        return number > 70;
    }

    private static void displayResult(boolean success) {
        if (success) {
            System.out.println("\u001B[32mAccess Granted!\u001B[0m");
        } else {
            System.out.println("\u001B[31mAccess Denied!\u001B[0m");
        }
    }
}
