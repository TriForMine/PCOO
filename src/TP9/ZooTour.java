package TP9;

import TP9.Animals.Animal;

public class ZooTour extends Tour<Animal> {
    public ZooTour() {
        super();
    }

    @Override
    public ZooTour add(Animal animal) {
        super.add(animal);
        return this;
    }
}
