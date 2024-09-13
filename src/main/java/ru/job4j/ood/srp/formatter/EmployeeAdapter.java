package ru.job4j.ood.srp.formatter;
import com.google.gson.*;
import ru.job4j.ood.srp.model.Employee;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EmployeeAdapter implements JsonSerializer<Employee> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", employee.getName());
        jsonObject.addProperty("hired", dateFormat.format(employee.getHired().getTime()));
        jsonObject.addProperty("fired", dateFormat.format(employee.getFired().getTime()));
        jsonObject.addProperty("salary", employee.getSalary());
        return jsonObject;
    }
}