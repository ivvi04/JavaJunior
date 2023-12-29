package ru.lakeevda.lesson1.task2.food.interfaces;

import ru.lakeevda.lesson1.task2.thing.interfaces.Thing;

/**
 * Еда
 */
public interface Food extends Thing {

    /**
     * Получить наличие протеинов в еде
     * @return Наличие протеинов
     */
    boolean  getProteins();

    /**
     * Получить наличие жиров в еде
     * @return Наличие жиров
     */
    boolean getFats();

    /**
     * Получить наличие углеводов в еде
     * @return Наличие углеводов
     */
    boolean getCarbohydrates();

}
