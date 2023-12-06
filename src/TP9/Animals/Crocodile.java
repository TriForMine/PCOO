package TP9.Animals;

import TP9.Diet;
import TP9.Persons.Person;

public final class Crocodile extends Animal {
    public Crocodile(String name, Person keeper, int age) {
        super(name, keeper, age, Diet.CARNIVOROUS);
    }
}
