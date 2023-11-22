package TP7;

public class AudioBook {
    private String author;
    private String title;
    private String reader;
    private double price;
    private int duration;

    public AudioBook(String author, String title, String reader, double price, int duration) {
        this.author = author;
        this.title = title;
        this.reader = reader;
        this.price = price;
        this.duration = duration;
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

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
