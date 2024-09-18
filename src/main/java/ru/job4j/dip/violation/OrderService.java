package ru.job4j.dip.violation;

/*
Нарушение: прямая зависимость от конкретной реализации уведомлений(через email),
когда нужно будет поменять тип уведодомления придется изменять код.
 */
public class OrderService {
    public void completeOrder(Order order) {
        EmailNotificationService emailService = new EmailNotificationService();
        emailService.send(order);
    }

    private static class EmailNotificationService {

        public void send(Order order) {
            /*
            Логика метода
             */
        }
    }

    private static class Order {
        /*
        Логика класса
         */
    }
}
