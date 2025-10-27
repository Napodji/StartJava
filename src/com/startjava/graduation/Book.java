package com.startjava.graduation;

import java.time.Year;

public class Book {
    private static final int MIN_YEAR = 1800;

    private String author;
    private String title;
    private Year publishedYear;

    public Book(String author, String title, Year publicationYear) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }

        if (publicationYear == null) {
            throw new IllegalArgumentException("Год издания не может быть пустым");
        }

        if (publicationYear.isBefore(Year.of(MIN_YEAR)) || publicationYear.isAfter(Year.now())) {
            throw new IllegalArgumentException(
                    "Год издания должен быть между " + MIN_YEAR + " и " + Year.now());
        }

        this.author = author;
        this.title = title;
        this.publishedYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + publishedYear;
    }
}
