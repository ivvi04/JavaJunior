package ru.lakeevda.lesson1.task2.food.semifinishedfood.classes;

import ru.lakeevda.lesson1.task2.food.semifinishedfood.interfaces.SemiFinishedFood;

/**
 * Пельмени
 */
public class DumplingsMeat implements SemiFinishedFood {
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
        return "Пельмени";
    }
}
