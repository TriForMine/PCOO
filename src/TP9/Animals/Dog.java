package TP9.Animals;

import TP9.Diet;
import TP9.Persons.Person;

public final class Dog extends Animal {
    public Dog(String name, Person keeper, int age) {
        super(name, keeper, age, Diet.CARNIVOROUS);
    }
}
