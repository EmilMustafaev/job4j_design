package ru.job4j.ood.srp.formatter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateAdapter extends XmlAdapter<String, Calendar> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar unmarshal(String v) throws Exception {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateFormat.parse(v));
        return calendar;
    }

    @Override
    public String marshal(Calendar v) throws Exception {
        return dateFormat.format(v.getTime());
    }
}
