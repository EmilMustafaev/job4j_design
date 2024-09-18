package ru.job4j.ood.lsp;

import java.util.ArrayList;
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

    public void resort() {
        List<Food> allFoods = new ArrayList<>();
        for (Store store : stores) {
            allFoods.addAll(store.getFoods());
        }

        for (Store store : stores) {
            store.getFoods().clear();
        }
        for (Food food : allFoods) {
            distribute(food);
        }
    }
}
