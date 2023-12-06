package TP9.Animals;

import TP9.Diet;
import TP9.Persons.Person;

public final class Cat extends Animal {
    public Cat(String name, Person keeper, int age) {
        super(name, keeper, age, Diet.CARNIVOROUS);
    }
}
