package TP9.Animals;

import TP9.Diet;
import TP9.Persons.Person;

public final class Tiger extends Animal {
    public Tiger(String name, Person keeper, int age) {
        super(name, keeper, age, Diet.CARNIVOROUS);
    }
}
