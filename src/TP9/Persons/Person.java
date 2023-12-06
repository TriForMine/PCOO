package TP9.Persons;

import TP9.Animals.Animal;
import TP9.Diet;
import TP9.Exceptions.IncompatibleFoodException;

public class Person {
    public String firstName;
    public String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void feedMeat(Animal a) {
        if (a.getDiet() != Diet.CARNIVOROUS) {
            throw new IncompatibleFoodException("This animal is not carnivorous");
        } else {
            System.out.println("Feeding " + a.getName() + " with meat");
        }
    }

    public void feedPlants(Animal a) {
        if (a.getDiet() != Diet.HERBIVOROUS) {
            throw new IncompatibleFoodException("This animal is not herbivorous");
        } else {
            System.out.println("Feeding " + a.getName() + " with plant");
        }
    }

    public void feedFruits(Animal a) {
        if (a.getDiet() != Diet.OMNIVOROUS) {
            throw new IncompatibleFoodException("This animal is not omnivorous");
        } else {
            System.out.println("Feeding " + a.getName() + " with fruits");
        }
    }
}
