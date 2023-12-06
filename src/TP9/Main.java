package TP9;

import TP9.Animals.Animal;
import TP9.Animals.AnimalFactory;
import TP9.Persons.Person;
import TP9.Persons.Visitor;

public final class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe");

        Animal dog = AnimalFactory.create("Dog", "Rex", person, 5);
        Animal cat = AnimalFactory.create("Cat", "Felix", person, 3);
        Animal monkey = AnimalFactory.create("Monkey", "George", person, 2);
        Animal lion = AnimalFactory.create("Lion", "Simba", person, 4);
        Animal tiger = AnimalFactory.create("Tiger", "Shere Khan", person, 6);
        Animal crocodile = AnimalFactory.create("Crocodile", "Kroc", person, 7);
        Animal bat = AnimalFactory.create("Bat", "Batman", person, 1);
        Animal hippo = AnimalFactory.create("Hippo", "Hippopotamus", person, 8);

        person.feedMeat(dog);

        try {
            person.feedFruits(cat);
            throw new Exception("This should not happen");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ZooTour zooTour1 = new ZooTour()
                .add(dog)
                .add(cat)
                .add(monkey)
                .add(lion)
                .add(tiger)
                .add(crocodile)
                .add(bat)
                .add(hippo);

        ZooTour zooTour2 = new ZooTour()
                .add(dog)
                .add(cat);

        Visitor visitor = new Visitor("Jane", "Doe");

        visitor.followTour(zooTour1);
        visitor.runTour();

        System.out.println();

        visitor.followTour(zooTour2);
        visitor.runTour();

        System.out.println();

        visitor.followTour(zooTour1);
        visitor.runTour();
    }
}
