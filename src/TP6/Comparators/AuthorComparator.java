package TP6.Comparators;

import TP6.Classes.Book;

import java.util.Comparator;

public class AuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book book2) {
        return book.getAuthor().compareTo(book2.getAuthor());
    }
}
