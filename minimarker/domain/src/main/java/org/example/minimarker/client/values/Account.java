package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Account implements ValueObject<String> {

    private final String number;
    private final String type;

    public Account(String number, String type) throws IllegalAccessException {
        this.number = Objects.requireNonNull(number);
        this.type = Objects.requireNonNull(type);



        if(number.length() < 6){
            throw new IllegalAccessException("debe ingresar minimo 6 números");
        }
    }

    @Override
    public String value() {
        return number+"-"+type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Account that = (Account)  obj;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
