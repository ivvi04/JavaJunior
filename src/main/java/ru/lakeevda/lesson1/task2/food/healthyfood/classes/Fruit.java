package ru.lakeevda.lesson1.task2.food.healthyfood.classes;

import ru.lakeevda.lesson1.task2.food.healthyfood.interfaces.HealthyFood;

/**
 * Фрукт
 */
public class Fruit implements HealthyFood {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Фрукт";
    }
}
