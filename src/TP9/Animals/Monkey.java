package TP9.Animals;

import TP9.Diet;
import TP9.Persons.Person;

public final class Monkey extends Animal {
    public Monkey(String name, Person keeper, int age) {
        super(name, keeper, age, Diet.HERBIVOROUS);
    }
}
