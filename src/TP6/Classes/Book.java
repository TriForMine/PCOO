package TP6.Classes;

import org.jetbrains.annotations.NotNull;

public final class Book implements Comparable<Book> {
    private String author;
    private String title;
    private double price;
    private String isbn;

    public Book(String author, String title, double price, String isbn) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book b) {
            return this.isbn.equals(b.isbn);
        }

        return false;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%s) - %.2f€", title, author, isbn, price);
    }

    @Override
    public int compareTo(@NotNull Book book) {
        return 0;
    }
}
