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

        int[][] reversedResults = new int[originalTransactions.length][];

        for (int i = 0; i < originalTransactions.length; i++) {
            reversedResults[i] = reverseTransactions(originalTransactions[i]);
        }

        for (int i = 0; i < originalTransactions.length; i++) {
            printTransactionInfo(originalTransactions[i], reversedResults[i]);
        }
    }

    private static int[] reverseTransactions(int[] transactions) {
        if (transactions == null) {
            return null;
        }

        int length = transactions.length;
        int[] reversedTransactions = new int[length];

        for (int i = 0; i < length; i++) {
            reversedTransactions[i] = transactions[length - 1 - i];
        }

        return reversedTransactions;
    }

    private static void printTransactionInfo(int[] original, int[] reversed) {
        System.out.println("Исходные транзакции: " + Arrays.toString(original));

        if (reversed != null) {
            System.out.println(" В обратном порядке: " + Arrays.toString(reversed));
        } else {
            System.out.println(" В обратном порядке: null");
        }

        System.out.println();
    }
}
