package ru.lakeevda.lesson1.task2.cart.classes;

import ru.lakeevda.lesson1.task2.market.classes.UMarket;
import ru.lakeevda.lesson1.task2.food.interfaces.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Корзина
 *
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;
    private Integer check;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     *
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public void cardBalancing() {
        this.check = 0;
        boolean balance = addToBalance(Food::getProteins);
        balance = balance && addToBalance(Food::getFats);
        balance = balance && addToBalance(Food::getCarbohydrates);
        String s = "";
        if (check == 3) s = " уже";
        if (balance) System.out.println("Корзина" + s + " сбалансирована по БЖУ.");
        else System.out.println("Невозможно сбалансировать корзину по БЖУ.");
    }

    private boolean addToBalance(Predicate<Food> food) {
        boolean result = false;
        if (foodstuffs.stream().noneMatch(food)) {
            result = foodstuffs.add((T) market.getThings(Food.class).stream()
                    .filter(food)
                    .findAny()
                    .get());
        } else {
            check++;
            result = true;
        }
        return result;
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    public void printFoodstuffs() {
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");*/


        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));
    }
}
