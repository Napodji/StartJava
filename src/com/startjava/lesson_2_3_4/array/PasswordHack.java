package com.startjava.lesson_2_3_4.array;

public class PasswordHack {
    public static void main(String[] args) throws InterruptedException {
        boolean result = hack();
        showAccessMessage(result);
    }

    private static boolean hack() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        final int rotations = 3;

        System.out.print("Hacking:....");

        for (int i = 0; i < rotations * spins.length; i++) {
            char symbol = spins[i % spins.length];
            System.out.print("\b" + symbol);
            Thread.sleep(150);
        }

        return (int) (Math.random() * 100) > 70;
    }

    private static void showAccessMessage(boolean success) {
        String message = success
                ? "\u001B[32mAccess Granted!\u001B[0m"
                : "\u001B[31mAccess Denied!\u001B[0m";

        System.out.println(message);
    }
}
