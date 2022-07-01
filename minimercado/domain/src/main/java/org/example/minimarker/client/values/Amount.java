package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Amount implements ValueObject<Double> {

    private final Double amount;

    public Amount() {
        this.amount = 0.0;
    }

    private Amount(Double amount) throws IllegalAccessException {
        this.amount = Objects.requireNonNull(amount);
        if(amount < 0 ){
            throw new IllegalAccessException("El puntaje no puede ser inferior a cero");
        }

    }

    public Amount changeamount(Double amount) throws IllegalAccessException {
        return new Amount(amount);
    }

    @Override
    public Double value() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Amount that = (Amount)  obj;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
