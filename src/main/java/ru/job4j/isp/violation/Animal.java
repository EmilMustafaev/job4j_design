package ru.job4j.isp.violation;

/*
Нарушение: Неправильно выделение абстракции, нужно разделить интерфейсы на более специфичные,
не все животные умеют летать, плавать и т.д
 */
public interface Animal {
    void fly();
    void swim();
    void run();
}
