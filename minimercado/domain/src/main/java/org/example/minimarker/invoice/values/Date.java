package org.example.minimarker.invoice.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.minimarker.client.values.NameClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Date implements ValueObject<String> {

    private final LocalDate date;
    private final String format;

    public Date(int day, int month, int year) {
        try {
            date = LocalDate.of(year, month, day);
            if(date.isAfter(LocalDate.now())){
                throw new IllegalArgumentException("Not valid date of birth");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        format = generateFormat();
    }

    private String generateFormat() {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
    }

    @Override
    public String value() {
        return format;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if( obj == null || getClass() != obj.getClass()) return false;
        Date that = (Date) obj;
        return Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format);
    }
}
