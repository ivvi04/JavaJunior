package ru.lakeevda.lesson1.task2.food.snack.classes;

import ru.lakeevda.lesson1.task2.food.snack.interfaces.Snack;

/**
 * Шоколадный батончик
 */
public class ChocolateBar implements Snack {
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
        return "Шоколадный батончик";
    }
}
