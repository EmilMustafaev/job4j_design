package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Shop extends AbstractStore {
    @Override
    public boolean accept(Food food) {
        double percentage = calculateExpiryPercentage(food);
        return percentage >= 25 && percentage < 100;
    }

    @Override
    public void add(Food food) {
        double percentage = calculateExpiryPercentage(food);
        if (percentage > 75 && percentage < 100) {
            food.setPrice(food.getPrice() * (1 - food.getDiscount()));
        }
        foods.add(food);
    }
}
