package com.startjava.graduation;

import java.time.Year;
import java.util.Scanner;

public class UserMenu {
    private static final int SHELF_WIDTH = 44;
    private static final String SHELF_LINE = "-".repeat(SHELF_WIDTH);
    private static final int TYPING_DELAY_MS = 50;

    private Bookcase bookcase;
    private Scanner scanner;

    public UserMenu() {
        bookcase = new Bookcase();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        UserMenu menu = new UserMenu();
        menu.start();
    }

    public void start() {
        printWelcome();
        boolean running = true;

        while (running) {
            printBookcase();
            printMenu();
            String choice = inputMenuChoice();

            switch (choice) {
                case "1" -> addBook();
                case "2" -> findBook();
                case "3" -> deleteBook();
                case "4" -> clearBookcase();
                case "5" -> running = false;
                default -> System.out.println("Ошибка: неизвестная команда");
            }

            if (running) {
                waitForEnter();
            }
        }

        scanner.close();
        System.out.println("\nПрограмма завершена. До свидания!");
    }

    private void printWelcome() {
        String welcome = """

╔════════════════════════════════════════════╗
║     ДОБРО ПОЖАЛОВАТЬ В КНИЖНЫЙ ШКАФ!       ║
╚════════════════════════════════════════════╝
""";

        typewriterEffect(welcome);
        waitForEnter();
    }

    private void typewriterEffect(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(TYPING_DELAY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void printBookcase() {
        System.out.println("\n" + "=".repeat(SHELF_WIDTH + 2));
        System.out.println("В шкафу книг - " + bookcase.getSize() +
                ", свободно полок - " + bookcase.getFreeSlots());
        System.out.println("=".repeat(SHELF_WIDTH + 2));

        if (bookcase.getSize() == 0) {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }

        Book[] books = bookcase.getBooks();
        for (Book book : books) {
            System.out.println("|" + formatBookForShelf(book) + "|");
            System.out.println("|" + SHELF_LINE + "|");
        }
    }

    private String formatBookForShelf(Book book) {
        String bookStr = book.toString();
        if (bookStr.length() > SHELF_WIDTH) {
            return bookStr.substring(0, SHELF_WIDTH);
        }
        return bookStr + " ".repeat(SHELF_WIDTH - bookStr.length());
    }

    private void printMenu() {
        System.out.println("""

МЕНЮ:
1. Добавить книгу
2. Найти книгу
3. Удалить книгу
4. Очистить шкаф
5. Завершить
""");
    }

    private String inputMenuChoice() {
        while (true) {
            System.out.print("Выберите пункт меню: ");
            String input = scanner.nextLine().trim();

            if (input.matches("[1-5]")) {
                return input;
            }

            try {
                Integer.parseInt(input);
                System.out.println("Ошибка: Неверное значение меню (" + input +
                        "). Допустимые значения: 1-5");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: значение должно быть целым числом");
            }
        }
    }

    private void addBook() {
        System.out.println("\n--- Добавление книги ---");

        System.out.print("Введите автора: ");
        String author = scanner.nextLine().trim();

        System.out.print("Введите название: ");
        String title = scanner.nextLine().trim();

        Year year = inputYear();

        try {
            Book book = new Book(author, title, year);
            if (bookcase.add(book)) {
                System.out.println("\n✓ Книга успешно добавлена!");
            } else {
                System.out.println("\n✗ Ошибка: не удалось добавить книгу");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\n✗ " + e.getMessage());
        }
    }

    private Year inputYear() {
        while (true) {
            System.out.print("Введите год издания: ");
            String input = scanner.nextLine().trim();

            try {
                int yearValue = Integer.parseInt(input);
                return Year.of(yearValue);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: год должен быть целым числом");
                System.out.println("Попробуйте еще раз:");
            } catch (Exception e) {
                System.out.println("Ошибка: некорректный год");
                System.out.println("Попробуйте еще раз:");
            }
        }
    }

    private void findBook() {
        System.out.println("\n--- Поиск книги ---");
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine().trim();

        Book book = bookcase.find(title);

        if (book != null) {
            System.out.println("\n✓ Книга найдена: " + book);
        } else {
            System.out.println("\n✗ Книга с названием \"" + title + "\" не найдена");
        }
    }

    private void deleteBook() {
        System.out.println("\n--- Удаление книги ---");
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine().trim();

        if (bookcase.delete(title)) {
            System.out.println("\n✓ Книга успешно удалена!");
        } else {
            System.out.println("\n✗ Книга с названием \"" + title + "\" не найдена");
        }
    }

    private void clearBookcase() {
        if (bookcase.getSize() == 0) {
            System.out.println("\n✗ Шкаф уже пуст");
            return;
        }

        System.out.print("\nВы уверены, что хотите удалить все книги? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            bookcase.clear();
            System.out.println("\n✓ Шкаф успешно очищен!");
        } else {
            System.out.println("\n✗ Операция отменена");
        }
    }

    private void waitForEnter() {
        System.out.println("\nДля продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }
}
