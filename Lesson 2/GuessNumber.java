import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int guessNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        this.guessNumber = (int) (Math.random() * 100) + 1;
    }

    public void start(Scanner scanner) {
        Player currentPlayer = player1;

        do {
            System.out.println("Ход игрока " + currentPlayer.getName() + ". Введите число: ");

            String input = scanner.nextLine();
            int guess = Integer.parseInt(input);

            if (guess == guessNumber) {
                System.out.println("Игрок " + currentPlayer.getName() + " угадал число!");
                break;
            } else if (guess < guessNumber) {
                System.out.println("Число больше!");
            } else {
                System.out.println("Число меньше!");
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        } while (true);
    }
}
