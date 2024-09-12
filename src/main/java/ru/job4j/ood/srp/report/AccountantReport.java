package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Locale;
import java.util.function.Predicate;

public class AccountantReport implements Report {
    private final Store store;
    private final CurrencyConverter converter;
    private final Currency targetCurrency;


    public AccountantReport(Store store, CurrencyConverter converter, Currency targetCurrency) {
        this.store = store;
        this.converter = converter;
        this.targetCurrency = targetCurrency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary in ").append(targetCurrency).append("; ");
        for (Employee employee : store.findBy(filter)) {
            double convertedSalary = converter.convert(Currency.RUB, employee.getSalary(), targetCurrency);
            text.append(employee.getName()).append("; ")
                    .append(String.format(Locale.US, "%.2f", convertedSalary)).append(";");
        }
        return text.toString();
    }

}
