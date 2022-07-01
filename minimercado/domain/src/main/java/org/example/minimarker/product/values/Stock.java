package org.example.minimarker.product.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.minimarker.invoice.values.Value;

import java.util.Objects;

public class Stock implements ValueObject<Integer> {

    private final Integer value;

    public Stock(Integer value) throws IllegalAccessException {
        this.value = value;

        if(value < 0 ){
            throw new IllegalAccessException("El stock no puede ser inferior a cero");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Stock that = (Stock)  obj;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
