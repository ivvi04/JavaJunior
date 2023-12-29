package ru.lakeevda.lesson1.task2.thing.classes;

import ru.lakeevda.lesson1.task2.thing.interfaces.Thing;

/**
 * Блокнот
 */
public class Notebook implements Thing {
    @Override
    public String getName() {
        return "Блокнот";
    }
}
