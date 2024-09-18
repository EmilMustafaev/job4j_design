package ru.job4j.ood.lsp;

import java.util.List;

public interface Store {
    void add(Food food);
    boolean accept(Food food);
     List<Food> getFoods();
}
