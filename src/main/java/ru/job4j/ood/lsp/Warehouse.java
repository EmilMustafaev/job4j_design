package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Warehouse extends AbstractStore {
    @Override
    public boolean accept(Food food) {
        double percentage = calculateExpiryPercentage(food);
        return percentage < 25;
    }
}
