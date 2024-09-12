package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

public class AccountantReportTest {
    @Test
    public void whenReportInUSD() {
        MemoryStore store = new MemoryStore();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        store.add(new Employee("Ivan", Calendar.getInstance(), Calendar.getInstance(), 100));
        Report accountantReport = new AccountantReport(store, converter, Currency.USD);


        String expected = "Name; Salary in USD; Ivan; 1,62;";
        assertThat(accountantReport.generate(employee -> true)).isEqualTo(expected);
    }
}