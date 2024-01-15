package ru.lakeevda.lesson2.task1;

import ru.lakeevda.lesson2.task1.animal.classes.Animal;
import ru.lakeevda.lesson2.task1.animal.classes.Cat;
import ru.lakeevda.lesson2.task1.animal.classes.Dog;
import ru.lakeevda.lesson2.task1.animal.enums.Gender;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Dog("Рекс", 10, 0.9),
                new Dog("Альба", 3, 0.6),
                new Cat("Пират", 7, Gender.MALE),
                new Cat("Муська", 2, Gender.FAMALE)
        };

        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName() + ":");
            System.out.println("Кличка: " + animal.getName());
            System.out.println("Возраст: " + animal.getAge());

            try {
                Method method = animal.getClass().getMethod("makeSound");
                method.invoke(animal);
            } catch (Exception e) {
                System.out.println("Метод makeSound() не найден");
            }

            if (animal instanceof Cat) {
                try {
                    Cat cat = (Cat) animal;
                    Method method = cat.getClass().getMethod("purr");
                    method.invoke(cat);
                } catch (Exception e) {
                    System.out.println("Метод purr не найден");
                }
            }

            if (animal instanceof Dog) {
                try {
                    Dog dog = (Dog) animal;
                    Method method = dog.getClass().getMethod("down");
                    method.invoke(dog);
                } catch (Exception e) {
                    System.out.println("Метод down не найден");
                }
            }
        }
    }
}
