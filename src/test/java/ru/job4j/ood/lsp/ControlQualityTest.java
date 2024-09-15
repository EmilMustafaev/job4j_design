package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControlQualityTest {

    @Test
    public void whenDistributeToWarehouse() {
        Food food = new Food("Milk", LocalDate.now().minusDays(1), LocalDate.now().plusDays(10), 100, 0.2);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality control = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        control.distribute(food);
        assertTrue(warehouse.getFoods().contains(food));
    }

    @Test
    public void whenDistributeToShop() {
        Food food = new Food("Milk", LocalDate.now().minusDays(50), LocalDate.now().plusDays(25), 200, 0.2);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality control = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        control.distribute(food);
        assertTrue(shop.getFoods().contains(food));
    }

    @Test
    void whenProductWithExpiryMoreThan75PercentThenGoesToShopWithDiscount() {
        Shop shop = new Shop();
        Food food = new Food("Cheese", LocalDate.now().minusDays(80), LocalDate.now().plusDays(20), 200.0, 0.2);

        assertTrue(shop.accept(food));
        shop.add(food);
        assertEquals(160.0, food.getPrice());
    }

    @Test
    public void whenDistributeToTrash() {
        Food food = new Food("Cheese", LocalDate.now().minusDays(100), LocalDate.now().minusDays(1), 200.0, 0.2);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality control = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        control.distribute(food);
        assertTrue(trash.getFoods().contains(food));
    }
}