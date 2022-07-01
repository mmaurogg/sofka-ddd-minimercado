package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Category implements ValueObject<String> {

    private final String category;

    public Category(String category) {
        this.category = Objects.requireNonNull(category);
    }

    @Override
    public String value() {
        return category;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Category that = (Category)  obj;
        return Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }

}
