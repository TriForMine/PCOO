package TP6.Comparators;

import TP6.Classes.Book;

import java.util.Comparator;

public class PriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book book2) {
        return Double.compare(book.getPrice(), book2.getPrice());
    }
}
