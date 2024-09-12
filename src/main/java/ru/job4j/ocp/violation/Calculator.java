package ru.job4j.ocp.violation;

public class Calculator {
    /* Нарушение : изменение существующего кода для того чтобы добавить
    другие операции(умножение, деление).
     */
    public int calculate(int a, int b, String operation) {
        if (operation.equals("sum")) {
            return a + b;
        } else if (operation.equals("subtract")) {
            return a - b;
        }
        return 0;
    }
}
