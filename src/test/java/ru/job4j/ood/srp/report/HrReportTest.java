package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

public class HrReportTest {
    @Test
    public void whenSortedBySalaryDescending() {
        MemoryStore store = new MemoryStore();
        store.add(new Employee("Ivan", Calendar.getInstance(), Calendar.getInstance(), 100));
        store.add(new Employee("Petr", Calendar.getInstance(), Calendar.getInstance(), 200));
        Report hrReport = new HrReport(store);


        String expected = " Name; Salary; Petr: 200.0; Ivan: 100.0; ";
        assertThat(hrReport.generate(employee -> true)).isEqualTo(expected);
    }
}