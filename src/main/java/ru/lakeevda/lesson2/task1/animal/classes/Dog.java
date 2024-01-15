package ru.lakeevda.lesson2.task1.animal.classes;

public class Dog extends Animal {
    double height;

    public Dog(String name, int age, double height) {
        super(name, age);
        this.height = height;
    }

    public void makeSound() {
        System.out.println("Гав");
    }

    public void down() {
        System.out.println("Собака легла");
    }

}
