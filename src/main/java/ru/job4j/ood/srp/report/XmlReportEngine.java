package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {

    private final MemoryStore store;
    private final JAXBContext context;

    public XmlReportEngine(MemoryStore store) throws JAXBException {
        this.store = store;
        this.context = JAXBContext.newInstance(Employees.class);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(new Employees(store.findBy(filter)), writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
