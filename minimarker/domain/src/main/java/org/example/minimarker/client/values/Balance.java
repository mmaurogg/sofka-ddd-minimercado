package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Balance implements ValueObject<Double> {

    private final Double balance;

    public Balance(Double balance) {
        this.balance = balance;
    }

    @Override
    public Double value() {
        return balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Balance that = (Balance)  obj;
        return Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
