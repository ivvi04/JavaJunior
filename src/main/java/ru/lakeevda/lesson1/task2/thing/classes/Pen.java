package ru.lakeevda.lesson1.task2.thing.classes;

import ru.lakeevda.lesson1.task2.thing.interfaces.Thing;

/**
 * Ручка
 */
public class Pen implements Thing {
    @Override
    public String getName() {
        return "Ручка";
    }
}
