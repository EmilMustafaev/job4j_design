package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.util.function.Predicate;

public class HrReport implements Report {
    private final Store store;

    public HrReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(" Name; Salary; ");
        store.findBy(filter).stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> text.append(employee.getName())
                        .append(": ")
                        .append(employee.getSalary())
                        .append("; "));
        return text.toString();
    }
}
