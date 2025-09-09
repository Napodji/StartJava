package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[][] data = {
                {},
                null,
                {5},
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1}
        };
        for (int[] transactions : data) {
            transactionInfo(transactions);
        }
    }

    private static int[] reverseTransactions(int[] transactions) {
        if (transactions == null) {
            return null;
        }

        int length = transactions.length;
        int[] reverseTransactions = new int[length];

        for (int i = 0; i < length; i++) {
            reverseTransactions[i] = transactions[length - 1 - i];
        }

        return reverseTransactions;
    }

    private static void transactionInfo(int[] transactions) {
        String original = Arrays.toString(transactions);
        String reversed = Arrays.toString(reverseTransactions(transactions));

        System.out.println("Исходные транзакции: " + original);
        System.out.println(" В обратном порядке: " + reversed);
        System.out.println();
    }
}
