package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class JsonReportEngineTest {

    @Test
    void whenAccountantsGenerated() throws JAXBException {
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
        Report engine = new JsonReportEngine(store);
        String expected = """
                [
                  {
                    "name": "Emil Mustafaev",
                    "hired": "04:01:2024 19:30",
                    "fired": "04:01:2024 19:30",
                    "salary": 5000.0
                  },
                  {
                    "name": "Vasilii Petrov",
                    "hired": "30:06:2024 21:05",
                    "fired": "30:06:2024 21:05",
                    "salary": 7000.0
                  }
                ]""";
        assertThat(engine.generate(em -> true)).isEqualTo(expected);

    }
}