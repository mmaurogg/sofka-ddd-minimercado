package org.example.minimarker.invoice.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Method implements ValueObject<String> {

    private final String method;

    public Method(String method) {
        this.method = Objects.requireNonNull(method);
    }

    @Override
    public String value() {
        return method;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Method that = (Method)  obj;
        return Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method);
    }
}
