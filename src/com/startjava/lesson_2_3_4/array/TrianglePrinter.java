package com.startjava.lesson_2_3_4.array;

public class TrianglePrinter {
    public static void main(String[] args) {
        char[][] tests = {
                {'0', '9'},
                {'/', '!'},
                {'A', 'J'}
        };
        boolean[] sortAscending = {true, false, false};

        for (int i = 0; i < tests.length; i++) {
            char leftEnd = tests[i][0];
            char rightEnd = tests[i][1];
            boolean ascending = sortAscending[i];

            printTriangle(leftEnd, rightEnd, ascending);
        }
    }

    private static void printTriangle(char leftEnd, char rightEnd, boolean ascending) {
        System.out.printf("Построение треугольников символов от '%c' до '%c', сортировка %s:%n",
                leftEnd, rightEnd, ascending ? "по возрастанию" : "по убыванию");

        char[] symbolRange = buildSymbolRange(leftEnd, rightEnd, ascending);

        if (symbolRange == null) {
            printError(leftEnd, rightEnd, ascending);
        } else {
            printTriangleSymbols(symbolRange);
        }
        System.out.println();
    }

    private static void printError(char leftBound, char rightBound, boolean ascending) {
        if (ascending) {
            System.out.printf("Ошибка: левая граница (%d, '%c') > правой (%d, '%c').%n",
                    (int) leftBound, leftBound, (int) rightBound, rightBound);
        } else {
            System.out.printf("Ошибка: левая граница (%d, '%c') < правой (%d, '%c').%n",
                    (int) leftBound, leftBound, (int) rightBound, rightBound);
        }
    }

    private static void printTriangleSymbols(char[] symbols) {
        int length = symbols.length;

        for (int i = 0; i < length; i++) {
            int padding = length - i - 1;
            int width = 2 * i + 1;

            System.out.print(" ".repeat(padding));
            System.out.print(String.valueOf(symbols[i]).repeat(width));
            System.out.println();
        }
    }

    private static char[] buildSymbolRange(char left, char right, boolean ascending) {
        if ((ascending && left > right) || (!ascending && left < right)) {
            return null;
        }

        int length = Math.abs(right - left) + 1;
        char[] symbols = new char[length];

        for (int i = 0; i < length; i++) {
            symbols[i] = (char) (ascending ? left + i : left - i);
        }
        return symbols;
    }
}
