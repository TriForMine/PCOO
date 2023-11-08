package TP6.Classes;

import TP6.Exceptions.InventoryException;

public class BookStore extends Inventory<Book> {
    public void restock(Inventory<Book> stockInventory) {
        for (Book book : stockInventory.getAll()) {
            this.add(book, stockInventory.get(book));
        }
    }

    public void sell(Inventory<Book> sellInventory) throws InventoryException {
        for (Book book : sellInventory.getAll()) {
            this.remove(book, sellInventory.get(book));
        }
    }
}
