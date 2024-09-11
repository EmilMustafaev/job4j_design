package ru.job4j.ood.srp;

public class OrderProcessor {
    /*Нарушение : Класс отвечает за обработку заказа и за его валидацию*/
    public void processOrder(String order) {
        if (validateOrder(order)) {
            return;
            /* Логика обработки заказа */
        }
    }

    private boolean validateOrder(String order) {
        /* Логика валидации заказа */
        return true;
    }
}
