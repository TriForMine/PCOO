package TP8;

public class Car extends Vehicle implements Passengers {
    private final int maxPassengers;
    private int passengers = 0;

    protected Car(String model, String brand, String color, int year, int maxPassengers) {
        super(model, brand, color, year);
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void addPassengers(int n) {
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
