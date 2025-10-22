package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printGameRules();

        System.out.print("Введите имя первого игрока: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1);

        System.out.print("Введите имя второго игрока: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2);

        GuessNumber game = new GuessNumber(player1, player2);
        String continuation = "yes";

        while (continuation.equals("yes")) {
            game.start(scanner);
            continuation = askToContinue(scanner);
        }

        scanner.close();
    }

    private static void printGameRules() {
        System.out.println("""
                
                ========== ИГРА "УГАДАЙ ЧИСЛО" ==========
                
                ПРАВИЛА:
                1. Компьютер загадывает число от 1 до 100
                2. Два игрока по очереди пытаются его угадать
                3. У каждого игрока по 10 попыток
                4. После каждой попытки даётся подсказка
                5. Побеждает тот, кто первым угадает число
                
                Неверный ввод не тратит попытки!
                ==========================================
                
                """);
    }

    private static String askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("\nСыграем еще? (yes/no): ");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("yes") || answer.equals("no")) {
                return answer;
            }
            System.out.println("Неверный ввод, повторите!");
        }
    }
}
