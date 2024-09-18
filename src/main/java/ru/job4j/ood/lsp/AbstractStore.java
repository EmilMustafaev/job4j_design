package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    public double calculateExpiryPercentage(Food food) {
        LocalDate now = LocalDate.now();
        long totalDays = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
        long passedDays = now.toEpochDay() - food.getCreateDate().toEpochDay();
        return ((double) passedDays / totalDays) * 100;
    }

}
