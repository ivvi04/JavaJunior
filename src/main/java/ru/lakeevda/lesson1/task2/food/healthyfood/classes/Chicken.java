package ru.lakeevda.lesson1.task2.food.healthyfood.classes;

import ru.lakeevda.lesson1.task2.food.healthyfood.interfaces.HealthyFood;

/**
 * Курица
 */
public class Chicken implements HealthyFood {
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Курица";
    }
}
