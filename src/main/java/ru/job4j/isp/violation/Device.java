package ru.job4j.isp.violation;

/*
Нарушение: Большой интерфейс устройства,
не всем реализациям потребуются все предствленные методы
 */
public interface Device {
    void input(String data);
    void calculate();
    void output();
    void connectToInternet();
}
