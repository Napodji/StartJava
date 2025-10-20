package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String continuation = "yes";

        while (continuation.equals("yes")) {
            System.out.print("Введите выражение (например: 2 + 3): ");
            String expression = scanner.nextLine();

            double result = calculator.calculate(expression);

            if (!Double.isNaN(result)) {
                printResult(expression, result);
            }

            continuation = askToContinue(scanner);
        }

        scanner.close();
    }

    private static void printResult(String expression, double result) {
        if (result == (long) result) {
            System.out.println(expression + " = " + (long) result);
        } else {
            System.out.printf("%s = %.3f%n", expression, result);
        }
    }

    private static String askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes") || answer.equals("no")) {
                return answer;
            }

            System.out.println("Ошибка: введите yes или no");
        }
    }
}
