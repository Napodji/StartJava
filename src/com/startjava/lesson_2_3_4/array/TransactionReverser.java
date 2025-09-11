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
            printTransactionInfo(transactions);
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

    private static void printTransactionInfo(int[] transactions) {
        System.out.println("Исходные транзакции: " + Arrays.toString(transactions));

        if (transactions != null) {
            System.out.println(" В обратном порядке: " + Arrays.toString(reverseTransactions(transactions)));
        } else {
            System.out.println(" В обратном порядке: null");
        }

        System.out.println();
    }
}
