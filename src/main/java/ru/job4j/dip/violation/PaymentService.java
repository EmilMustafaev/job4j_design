package ru.job4j.dip.violation;

/*
Нарушение : логирование напрямую в консоль, в дальнейшем,
если нужно будет поменять способ логирования(записывать в файл, БД), придется изменять код.
 */
public class PaymentService {
    public void processPayment() {
        System.out.println("Payment processed successfully");
    }
}
