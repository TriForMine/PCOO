package TP7;

public class PrintingHouse {
    private static final PrintingHouse instance = new PrintingHouse();

    private PrintingHouse() {
    }

    public static PrintingHouse getInstance() {
        return instance;
    }

    public Book printBook(String type, String title, String author, int pages, String isbn) {
        return switch (type) {
            case "comics" -> new Comics(title, author, pages, isbn);
            case "hardcover" -> new Hardcover(title, author, pages, isbn);
            case "manuscript" -> new Manuscript(title, author, pages, isbn);
            case "softcover" -> new Softcover(title, author, pages, isbn);
            default -> throw new IllegalArgumentException("Invalid book type");
        };
    }
}
