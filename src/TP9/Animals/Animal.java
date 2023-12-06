package TP9.Animals;

import TP9.Diet;
import TP9.Persons.Person;

public abstract class Animal {
    protected String name;
    protected Person keeper;
    protected int age;
    protected Diet diet;

    public Animal(String name, Person keeper, int age, Diet diet) {
        this.name = name;
        this.keeper = keeper;
        this.age = age;
        this.diet = diet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getKeeper() {
        return keeper;
    }

    public void setKeeper(Person keeper) {
        this.keeper = keeper;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }
}
