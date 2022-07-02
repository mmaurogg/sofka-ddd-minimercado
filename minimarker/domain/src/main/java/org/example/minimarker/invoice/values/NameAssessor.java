package org.example.minimarker.invoice.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.minimarker.client.values.NameClient;

import java.util.Objects;

public class NameAssessor implements ValueObject<String> {

    private final String name;

    public NameAssessor(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String value() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        NameAssessor that = (NameAssessor)  obj;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
