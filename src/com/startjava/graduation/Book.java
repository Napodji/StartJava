package com.startjava.graduation;

import java.time.Year;

public class Book {
    private static final int MIN_YEAR = 1800;

    private String author;
    private String title;
    private Year year;

    public Book(String author, String title, Year year) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        if (year == null) {
            throw new IllegalArgumentException("Год издания не может быть пустым");
        }

        if (year.getValue() < MIN_YEAR || year.isAfter(Year.now())) {
            throw new IllegalArgumentException(
                    "Год издания должен быть между " + MIN_YEAR + " и " + Year.now());
        }

        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Year getYear() {
        return year;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + year;
    }
}
