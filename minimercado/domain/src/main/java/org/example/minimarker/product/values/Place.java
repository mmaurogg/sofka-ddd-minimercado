package org.example.minimarker.product.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Place implements ValueObject<String> {

    private final String place;

    public Place(String place) {
        this.place = Objects.requireNonNull(place);
    }

    @Override
    public String value() {
        return place;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Place that = (Place)  obj;
        return Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place);
    }
}
