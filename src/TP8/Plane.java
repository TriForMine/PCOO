package TP8;

public class Plane extends TicketVehicle {
    protected Plane(String model, String brand, String color, int year, int maxPassengers) {
        super(model, brand, color, year, 599.99, maxPassengers);
    }

    @Override
    public void removePassengers(int n) {
        if (this.passengers - n != 0) {
            throw new IncoherentPassengersNumber("Every passenger must leave the plane");
        }

        this.passengers = 0;
    }
}
