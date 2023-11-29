package TP8;

public class Bus extends TicketVehicle {
    protected Bus(String model, String brand, String color, int year, int maxPassengers) {
        super(model, brand, color, year, 2.99, maxPassengers);
    }
}
