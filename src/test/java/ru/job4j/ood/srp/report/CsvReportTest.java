package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvReportTest {

    @Test
    public void whenCsvReportGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report engine = new CsvReport(store, new ReportDateTimeParser());
        store.add(worker);


        StringBuilder expected = new StringBuilder();
        expected.append("Name,Hired,Fired,Salary").append(System.lineSeparator())
                .append("Ivan,")
                .append(new ReportDateTimeParser().parse(worker.getHired())).append(",")
                .append(new ReportDateTimeParser().parse(worker.getFired())).append(",")
                .append(worker.getSalary())
                .append(System.lineSeparator());

        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}