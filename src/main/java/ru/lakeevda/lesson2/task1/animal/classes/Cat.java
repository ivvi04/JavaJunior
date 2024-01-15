package ru.lakeevda.lesson2.task1.animal.classes;

import ru.lakeevda.lesson2.task1.animal.enums.Gender;

public class Cat extends Animal {
    Gender gender;

    public Cat(String name, int age, Gender gender) {
        super(name, age);
        this.gender = gender;
    }

    public void makeSound() {
        System.out.println("Мяу");
    }

    public void purr() {
        System.out.println("Мур-мур...");
    }
}
