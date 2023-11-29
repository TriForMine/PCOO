package TP8;

public class Train extends TicketVehicle {

    protected Train(String model, String brand, String color, int year, int maxPassengers) {
        super(model, brand, color, year, 299.99, maxPassengers);
    }
}
