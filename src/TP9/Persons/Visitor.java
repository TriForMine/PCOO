package TP9.Persons;

import TP9.Animals.Animal;
import TP9.Exceptions.ForbiddenException;
import TP9.ZooTour;

public final class Visitor extends Person {
    private ZooTour currentTour;

    public Visitor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void feedMeat(Animal a) {
        throw new ForbiddenException("Visitors are not allowed to feed animals");
    }

    @Override
    public void feedPlants(Animal a) {
        throw new ForbiddenException("Visitors are not allowed to feed animals");
    }

    @Override
    public void feedFruits(Animal a) {
        throw new ForbiddenException("Visitors are not allowed to feed animals");
    }

    public void followTour(ZooTour tour) {
        if (currentTour != null) {
            currentTour.reset();
        }
        currentTour = tour;
    }

    public void runTour() {
        if (currentTour == null) {
            throw new NullPointerException("No tour to run");
        }

        while (!currentTour.ended()) {
            System.out.println(currentTour.next().getName());
        }
    }
}
