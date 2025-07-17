import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1.ВЫВОД ASCII-СИМВОЛОВ");
        System.out.printf("%-8s %-10s %s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int x = 33; x < 48; x++) {
            if (x % 2 != 0) {
                System.out.printf("%-8d %-10c ", x, x);
                System.out.println("Описание: " + Character.getName(x));
            }
        }
        for (int x = 98; x <= 122; x++) {
            if (x % 2 == 0) {
                System.out.printf("%-8d %-10c ", x, x);
                System.out.println("Описание: " + Character.getName(x));
            }
        }
        System.out.println("\n2.ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
        int line = 5;
        for (int a = 0; a < line; a++) {
            System.out.print("---------- ");
            for (int b = line - a; b > 0; b--) {
                System.out.print("*");
            }
            System.out.print(" ");
            for (int c = 0; c <= a; c++) {
                System.out.print("^");
            }
            System.out.println();
        }

        System.out.println("\n3.ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ");
        System.out.print("  |");
        for (int i = 2; i <= 9; i++) {
            System.out.printf(" %2d", i);
        }
        System.out.println();
        System.out.print("--+");
        for (int i = 0; i < 8; i++) {
            System.out.print("---");
        }
        System.out.println();
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int y = 2; y <= 9; y++) {
                System.out.printf(" %2d", i * y);
            }
            System.out.println();
        }

        System.out.println("\n3.ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        int start = 1;
        int end = 24;
        int numInLine = 5;
        int numCount = 0;
        for (int z = start; z < end; z++) {
            if (z % 2 != 0) {
                System.out.printf("%2d ", z);
                numCount++;
                if (numCount == numInLine) {
                    System.out.println();
                    numCount = 0;
                }
            }
        }
        for (int z = numCount; z < numInLine; z++) {
            System.out.printf("%2d ", 0);
        }
        System.out.println();

        System.out.println("\n4.ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX");
        int max;
        int min;
        if (10 > 5) {
            max = 10;
            min = 5;
        } else {
            max = 5;
            min = 10;
        }
        if (-1 > max) {
            max = -1;
        }
        if (-1 < min) {
            min = -1;
        }
        System.out.print("Числа в интервале (" + min + ", " + max + "): ");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n5.РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ");
        int num = 2234321;
        int numCopy = num;
        int reverse = 0;
        int countTwo = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            if (digit == 2) {
                countTwo++;
            }
            num /= 10;
        }
        boolean palindrome = (numCopy == reverse);
        String evenOdd = (countTwo % 2 == 0) ? "четным" : "нечетным";
        System.out.printf("%d - %s с %s (%d) количеством двоек%n",
                reverse,
                palindrome ? "палиндром" : "не палиндром",
                evenOdd,
                countTwo);

        System.out.println("\n7.ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        int number = 101002;
        int firstHalf = number / 1000;
        int secondHalf = number % 1000;
        int sumFirst = (firstHalf / 100) + ((firstHalf / 10) % 10) + (firstHalf % 10);
        int sumSecond = (secondHalf / 100) + ((secondHalf / 10) % 10) + (secondHalf % 10);
        if (sumFirst == sumSecond) {
            System.out.printf("%d - счастливое число\n", num);
            System.out.printf("Сумма цифр %03d = %d\n", secondHalf, sumSecond);
            System.out.printf("Сумма цифр %03d = %d\n", firstHalf, sumFirst);
        } else {
            System.out.println("Вам не повезло\n");
        }
        System.out.println("\n8.ГЕНЕРАТОР ПАРОЛЯ");
        Random random = new Random();
        String password = "";
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpeacial = false;
        for (int i = 0; i < 8; i++) {
            int charType = random.nextInt(4);
            char ch;
            if (charType == 0) {
                ch = (char) random.nextInt(97, 123);
                hasLower = true;
                password += ch;
            }
            if (charType == 1) {
                ch = (char) random.nextInt(65, 91);
                hasUpper = true;
                password += ch;
            }
            if (charType == 2) {
                ch = (char) random.nextInt(48, 58);
                hasDigit = true;
                password += ch;
            }
            if (charType == 3) {
                ch = (char) random.nextInt(33, 127);
                hasSpeacial = true;
                password += ch;
            }
        }
        String reliability;
        if (password.length() >= 8 && hasUpper && hasLower && hasSpeacial) {
            reliability = "надежный";
        } else if (password.length() >= 8 && (hasUpper || hasDigit)) {
            reliability = "Средний";
        } else {
            reliability = "Слабый";
        }
        System.out.println("Пароль: " + password);
        System.out.println("Надежность " + reliability);
    }
}
