package TP9.Animals;

import TP9.Persons.Person;

public final class AnimalFactory {
    private AnimalFactory() {
    }

    public static Animal create(String type, String name, Person keeper, int age) {
        return switch (type) {
            case "Bat" -> new Bat(name, keeper, age);
            case "Cat" -> new Cat(name, keeper, age);
            case "Crocodile" -> new Crocodile(name, keeper, age);
            case "Dog" -> new Dog(name, keeper, age);
            case "Hippo" -> new Hippo(name, keeper, age);
            case "Lion" -> new Lion(name, keeper, age);
            case "Monkey" -> new Monkey(name, keeper, age);
            case "Tiger" -> new Tiger(name, keeper, age);
            default -> throw new IllegalArgumentException("Unknown animal type");
        };
    }
}
