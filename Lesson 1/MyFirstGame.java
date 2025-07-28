import java.util.Random;
import java.util.Scanner;

public class MyFirstGame {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess;
        System.out.println("Угадай число, загаданное компьютером от 1 до 100!");
        do {
            System.out.println("Введите число");
            guess = scanner.nextInt();
            if (guess > num) {
                System.out.println("Число меньше");
            } else if (guess < num) {
                System.out.println("Число больше");
            }
        } while (guess != num);
        System.out.println("Угадали!");
    }
}