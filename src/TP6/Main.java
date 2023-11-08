package TP6;

import TP6.Classes.Book;
import TP6.Classes.BookStore;
import TP6.Classes.Inventory;
import TP6.Comparators.AuthorComparator;
import TP6.Comparators.PriceComparator;
import TP6.Comparators.TitleComparator;
import TP6.Exceptions.InventoryException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        Book lordOfTheRings = new Book("J. R. R. Tolkien", "The Lord of the Rings", 9.99, "978-0-618-57498-5");
        Book harryPotter = new Book("J. K. Rowling", "Harry Potter and the Philosopher's Stone", 19.99, "978-0-7475-3269-6");
        Book pokemon = new Book("Satoshi Tajiri", "Pokémon Red and Blue", 29.99, "978-1-59327-571-0");

        bookStore.restock(
                new Inventory<>() {{
                    add(lordOfTheRings, 5);
                    add(harryPotter, 3);
                    add(pokemon, 2);
                }}
        );

        System.out.println(bookStore);

        try {
            bookStore.sell(
                    new Inventory<>() {{
                        add(lordOfTheRings, 2);
                        add(harryPotter, 1);
                    }}
            );
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(bookStore);

        try {
            bookStore.sell(
                    new Inventory<>() {{
                        add(lordOfTheRings, 5);
                    }}
            );
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        }

        List<Book> books = bookStore.getAll();
        books.sort(new AuthorComparator());

        System.out.println("Tri par auteur");
        System.out.println(books);

        books.sort(new TitleComparator());

        System.out.println("Tri par titre");
        System.out.println(books);

        books.sort(new PriceComparator());

        System.out.println("Tri par prix");
        System.out.println(books);
    }
}
