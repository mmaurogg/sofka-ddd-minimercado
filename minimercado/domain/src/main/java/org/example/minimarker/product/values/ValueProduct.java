package org.example.minimarker.product.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.minimarker.invoice.values.Value;

import java.util.Objects;

public class ValueProduct implements ValueObject<Double> {

    private final Double value;

    public ValueProduct(Double value) throws IllegalAccessException {
        this.value = value;

        if(value < 0 ){
            throw new IllegalAccessException("El valor no puede ser inferior a cero");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        ValueProduct that = (ValueProduct)  obj;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
