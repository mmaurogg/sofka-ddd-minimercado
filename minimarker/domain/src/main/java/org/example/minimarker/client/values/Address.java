package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Address implements ValueObject<String> {

    private final String address;

    public Address(String address) {
        this.address = Objects.requireNonNull(address);
    }

    @Override
    public String  value() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Address that = (Address)  obj;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
