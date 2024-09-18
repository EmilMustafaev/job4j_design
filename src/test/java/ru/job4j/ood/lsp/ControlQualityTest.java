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

    @Test
    public void whenResortThenReDistributeAllFoods() {
        Food food1 = new Food("Milk", LocalDate.now().minusDays(1), LocalDate.now().plusDays(10), 100, 0.2);
        Food food2 = new Food("Cheese", LocalDate.now().minusDays(50), LocalDate.now().plusDays(25), 200, 0.2);
        Food food3 = new Food("Bread", LocalDate.now().minusDays(100), LocalDate.now().minusDays(1), 50, 0.1);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality control = new ControlQuality(Arrays.asList(warehouse, shop, trash));

        control.distribute(food1);
        control.distribute(food2);
        control.distribute(food3);

        assertTrue(warehouse.getFoods().contains(food1));
        assertTrue(shop.getFoods().contains(food2));
        assertTrue(trash.getFoods().contains(food3));

        food1.setCreateDate(LocalDate.now().minusDays(30));
        food2.setExpiryDate(LocalDate.now().minusDays(1));

        control.resort();

        assertTrue(shop.getFoods().contains(food1));
        assertTrue(trash.getFoods().contains(food2));
    }
}