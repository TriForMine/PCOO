package TP7;

public class AudiobookAdapter {
    private AudioBook audiobook;
    private String author;
    private String title;
    private double price;
    private String isbn;

    public AudiobookAdapter(AudioBook audiobook) {
        this.audiobook = audiobook;
        this.author = audiobook.getAuthor();
        this.title = audiobook.getTitle();
        this.price = audiobook.getPrice();
        this.isbn = audiobook.getAuthor() + " - " + audiobook.getTitle() + " - " + audiobook.getDuration() + " min" + " - " + audiobook.getPrice() + "€";
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
}
