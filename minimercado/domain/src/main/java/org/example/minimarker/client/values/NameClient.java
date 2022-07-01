package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NameClient implements ValueObject<String> {

    private final String name;

    public NameClient(String name) {
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
        NameClient that = (NameClient)  obj;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
