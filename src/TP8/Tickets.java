package TP8;

public interface Tickets {
    public default void sellTicket(double price) {
        System.out.println("Ticket sold for " + price + "€");
    }
}
