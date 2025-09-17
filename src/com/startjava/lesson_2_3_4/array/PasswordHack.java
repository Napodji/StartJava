package com.startjava.lesson_2_3_4.array;

public class PasswordHack {
    public static void main(String[] args) throws InterruptedException {
        boolean result = hack();
        showAccessMessage(result);
    }

    private static boolean hack() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        final int rotations = 3;

        System.out.print("Hacking: ");

        for (int i = 0; i < rotations * spins.length; i++) {
            char symbol = spins[i % spins.length];
            System.out.print("\b" + symbol);
            Thread.sleep(150);
        }

        return (int) (Math.random() * 100) > 70;
    }

    private static void showAccessMessage(boolean success) {
        String color = success ? "\u001B[32m" : "\u001B[31m";
        String messageText = success ? "Access Granted!" : "Access Denied!";

        System.out.println(color + messageText + "\u001B[0m");
    }
}
