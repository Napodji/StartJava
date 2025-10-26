package com.startjava.graduation;

import java.util.Arrays;

public class Bookcase {
    private static final int CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;

    private Book[] books;
    private int size;

    public Bookcase() {
        books = new Book[CAPACITY];
    }

    public boolean add(Book book) {
        if (book == null) {
            return false;
        }

        if (size == CAPACITY) {
            System.out.println("Ошибка: шкаф заполнен");
            return false;
        }

        if (size == books.length) {
            grow();
        }

        books[size] = book;
        size++;
        return true;
    }

    private void grow() {
        int newCapacity = (int) (books.length * GROWTH_FACTOR) + 1;
        books = Arrays.copyOf(books, newCapacity);
    }

    public Book find(String title) {
        if (title == null || title.isBlank()) {
            return null;
        }

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }

        return null;
    }

    public boolean delete(String title) {
        if (title == null || title.isBlank()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                int numMoved = size - i - 1;
                if (numMoved > 0) {
                    System.arraycopy(books, i + 1, books, i, numMoved);
                }
                books[--size] = null;
                return true;
            }
        }

        return false;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, size);
    }

    public int getSize() {
        return size;
    }

    public int getFreeShelves() {
        return CAPACITY - size;
    }

    public void clear() {
        Arrays.fill(books, 0, size, null);
        size = 0;
    }
}
