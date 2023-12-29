package ru.lakeevda.lesson1.task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(random.nextInt(10));
        System.out.println("Список: " + list);
        checkArray(list);
    }

    private static void checkArray(List<Integer> array) {
        OptionalDouble average = array.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .average();
        if (average.isPresent()) System.out.println("Среднее значение четных чисел: " + average.getAsDouble());
        else System.out.println("В списке отсутствуют четные числа");
    }
}
