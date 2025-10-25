package com.startjava.graduation;

import java.util.Arrays;

public class Bookcase {
    private static final int INITIAL_CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;

    private Book[] books;
    private int size;

    public Bookcase() {
        books = new Book[INITIAL_CAPACITY];
    }

    public boolean add(Book book) {
        if (book == null) {
            return false;
        }

        if (size == books.length) {
            grow();
        }

        books[size] = book;
        size++;
        return true;
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

    public int getFreeSlots() {
        return books.length - size;
    }

    public void clear() {
        Arrays.fill(books, 0, size, null);
        size = 0;
    }

    private void grow() {
        int newCapacity = (int) (books.length * GROWTH_FACTOR);
        books = Arrays.copyOf(books, newCapacity);
    }
}
