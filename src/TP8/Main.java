package TP8;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus("Citaro", "Mercedes", "White", 2018, 50);

        bus.getSummary();

        bus.addPassengers(10);
        bus.removePassengers(5);

        try {
            bus.removePassengers(10);
            throw new RuntimeException("Should have thrown an exception");
        } catch (IncoherentPassengersNumber ignored) {
        }

        System.out.println();

        Plane plane = new Plane("A380", "Airbus", "White", 2018, 500);

        plane.getSummary();
        plane.addPassengers(10);

        try {
            plane.removePassengers(5);
            throw new RuntimeException("Should have thrown an exception");
        } catch (IncoherentPassengersNumber ignored) {
        }

        plane.removePassengers(10);

        System.out.println();

        Train train = new Train("TGV", "SNCF", "White", 2018, 500);

        train.getSummary();
        train.addPassengers(10);

        System.out.println();

        Car car = new Car("Clio", "Renault", "White", 2018, 5);

        car.getSummary();
        car.addPassengers(3);
    }
}
