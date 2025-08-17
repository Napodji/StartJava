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

    private String checkGuess(int guess) {

        if (guess == guessNumber) {
            return "Игрок угадал число!";
        }

        if (guess < guessNumber) {
            return "Число больше!";
        }

        return "Число меньше!";
    }

    public void start(Scanner scanner) {
        Player currentPlayer = player1;

        do {
            System.out.println("Ход игрока " + currentPlayer.getName() + ". Введите число: ");

            String input = scanner.nextLine();
            int guess = Integer.parseInt(input);

            String result = checkGuess(guess);
            System.out.println(result);

            if (result.equals("Игрок угадал число!")) {
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        } while (true);
    }
}
