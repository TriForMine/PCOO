package TP7;

import org.jetbrains.annotations.NotNull;

public class Book implements Comparable<Book> {
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
        if (obj instanceof TP6.Classes.Book b) {
            return this.isbn.equals(b.getIsbn());
        }

        return false;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%s) - %.2f€", title, author, isbn, price);
    }

    @Override
    public int compareTo(@NotNull Book book) {
        return this.isbn.compareTo(book.isbn);
    }
}


