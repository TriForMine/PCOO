package TP9.Animals;

import TP9.Diet;
import TP9.Persons.Person;

public final class Bat extends Animal {
    public Bat(String name, Person keeper, int age) {
        super(name, keeper, age, Diet.FRUCTIVOROUS);
    }
}
