import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int number;
    private Scanner scanner;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = new Scanner(System.in);
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        this.number = (int) (Math.random() * 100) + 1;
    }

    public void startGame() {
        boolean isGameOver = false;
        boolean player1Turn = true;

        while (!isGameOver) {
            Player currentPlayer = player1Turn ? player1 : player2;
            System.out.println("Ход игрока " + currentPlayer.getName() + ". Введите число: ");

            String input = scanner.nextLine();

            int guess = Integer.parseInt(input);
            if (guess == number) {
                System.out.println("Игрок " + currentPlayer.getName() + " угадал число!");
                isGameOver = true;
            } else if (guess < number) {
                System.out.println("Число больше!");
            } else {
                System.out.println("Число меньше!");
            }
            player1Turn = !player1Turn;
        }
    }
}
