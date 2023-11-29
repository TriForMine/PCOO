package TP8;

public abstract class TicketVehicle extends Vehicle implements Passengers, Tickets {
    protected final double ticketPrice;
    protected int passengers = 0;
    protected int maxPassengers;

    protected TicketVehicle(String model, String brand, String color, int year, double ticketPrice, int maxPassengers) {
        super(model, brand, color, year);
        this.ticketPrice = ticketPrice;
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void addPassengers(int n) {
        for (int i = 0; i < n; i++) {
            this.sellTicket(2.99);
        }
        this.passengers = Math.min(this.passengers + n, this.maxPassengers);
    }

    @Override
    public void removePassengers(int n) {
        if (this.passengers - n < 0) {
            throw new IncoherentPassengersNumber("Cannot remove more passengers than there are");
        } else {
            this.passengers -= n;
        }
    }
}
