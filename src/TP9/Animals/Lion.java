package TP9.Animals;

import TP9.Diet;
import TP9.Persons.Person;

public final class Lion extends Animal {
    public Lion(String name, Person keeper, int age) {
        super(name, keeper, age, Diet.CARNIVOROUS);
    }
}
