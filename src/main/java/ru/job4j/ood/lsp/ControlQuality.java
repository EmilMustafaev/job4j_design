package ru.job4j.ood.lsp;

import java.util.List;

public class ControlQuality {
    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribute(Food food) {
        for (Store store : stores) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }
}
