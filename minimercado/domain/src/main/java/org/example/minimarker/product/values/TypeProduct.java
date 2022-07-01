package org.example.minimarker.product.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TypeProduct implements ValueObject<String> {

    private final String type;

    public TypeProduct(String type) {
        this.type = Objects.requireNonNull(type);
    }

    @Override
    public String value() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        TypeProduct that = (TypeProduct)  obj;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
