package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.EmployeeAdapter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;
import java.util.function.Predicate;


public class JsonReportEngine implements Report {

    private final MemoryStore store;
    private final Gson gson;

    public JsonReportEngine(MemoryStore store) {
        this.store = store;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Employee.class, new EmployeeAdapter())
                .setPrettyPrinting().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
