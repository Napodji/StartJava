import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean play = true;

        while (play) {
            System.out.println("Введите имя первого игрока: ");
            String name1 = scanner.nextLine();
            Player player1 = new Player(name1);

            System.out.println("Введите имя второго игрока: ");
            String name2 = scanner.nextLine();
            Player player2 = new Player(name2);

            GuessNumber game = new GuessNumber(player1, player2);

            System.out.println("\nНачинаем игру");
            game.start(scanner);

            boolean validInput = false;
            String response;

            while (!validInput) {
                System.out.println("Сыграем еще? (yes/no)");
                response = scanner.nextLine().toLowerCase();
                if (response.equals("yes")) {
                    play = true;
                    validInput = true;
                } else if (response.equals("no")) {
                    play = false;
                    validInput = true;
                } else {
                    System.out.println("Неверный ввод, повторите!");
                }
            }
        }
        scanner.close();
    }
}
