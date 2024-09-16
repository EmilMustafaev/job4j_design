package ru.job4j.isp.violation;

/*
Нарушение: Неправильноне выделение абстракции, разные реализации(работники) выполняют определенную
работу, выполнять всю работу не нужно.
 */
public interface Worker {
    void code();
    void design();
    void testSoftware();
}
