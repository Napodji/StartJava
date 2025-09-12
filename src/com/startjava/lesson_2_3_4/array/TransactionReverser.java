package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[][] originalTransactions = {
                {},
                null,
                {5},
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1}
        };

        for (int[] transactions : originalTransactions) {
            int[] reversed = reverseTransactions(transactions);
            printTransactions(transactions, reversed);
        }
    }

    private static int[] reverseTransactions(int[] transactions) {
        if (transactions == null) {
            return null;
        }

        int length = transactions.length;
        int[] reversedTransactions = new int[length];

        for (int value : transactions) {
            reversedTransactions[--length] = value;
        }

        return reversedTransactions;
    }

    private static void printTransactions(int[] original, int[] reversed) {
        System.out.println("Исходные транзакции: " + Arrays.toString(original));

        if (reversed != null) {
            System.out.println(" В обратном порядке: " + Arrays.toString(reversed));
        } else {
            System.out.println(" В обратном порядке: null");
        }

        System.out.println();
    }
}
