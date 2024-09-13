package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.assertj.core.api.Assertions.assertThat;

class XmlReportEngineTest {
    @Test
    void whenGenerated() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Employee employee = new Employee("Emil Mustafaev",
                new GregorianCalendar(2024, Calendar.JANUARY, 4, 19, 30),
                new GregorianCalendar(2024, Calendar.JANUARY, 4, 19, 30),
                5000.0);
        Employee employee1 = new Employee("Vasilii Petrov",
                new GregorianCalendar(2024, Calendar.JUNE, 30, 21, 5),
                new GregorianCalendar(2024, Calendar.JUNE, 30, 21, 5),
                7000.0);
        store.add(employee);
        store.add(employee1);
        Report engine = new XmlReportEngine(store);
        String expected = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>Emil Mustafaev</name>
                        <hired>04:01:2024 19:30</hired>
                        <fired>04:01:2024 19:30</fired>
                        <salary>5000.0</salary>
                    </employee>
                    <employee>
                        <name>Vasilii Petrov</name>
                        <hired>30:06:2024 21:05</hired>
                        <fired>30:06:2024 21:05</fired>
                        <salary>7000.0</salary>
                    </employee>
                </employees>
                """;
        assertThat(engine.generate(em -> true)).isEqualTo(expected);
    }

}