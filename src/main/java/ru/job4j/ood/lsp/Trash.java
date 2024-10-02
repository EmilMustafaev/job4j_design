package ru.job4j.ood.lsp;

import java.time.LocalDate;

/*
Делаю новые изменения
 */

public class Trash extends AbstractStore {
    @Override
    public boolean accept(Food food) {
        return LocalDate.now().isAfter(food.getExpiryDate());
    }
}
