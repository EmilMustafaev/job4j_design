package ru.job4j.lsp.violation;

class BankAccount {
    /*
    Нарушение : нарушение инвариантов, базовый класс не допускает отрицательного значения баланса,
    а в наследнике это проверка отсутсвует , что создает ситуацию с некорректным состоянием объекта.
     */
    protected double balance;

    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class CreditAccount extends BankAccount {

    public CreditAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }
}
