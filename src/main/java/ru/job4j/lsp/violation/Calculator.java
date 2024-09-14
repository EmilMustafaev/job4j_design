package ru.job4j.lsp.violation;

class Calculator {
    /*
    Нарушение : усиление предусловия, у родителя делитель не должен быть 0, а в
    наследнике это условие усиливается тем что число должно быть только положительное.
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }
}

class PositiveCalculator extends Calculator {
    @Override
    public double divide(double a, double b) {
        if (b <= 0) {
            throw new IllegalArgumentException("Divider must be a positive number");
        }
        return a / b;
    }
}
