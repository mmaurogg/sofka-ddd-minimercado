package org.example.minimarker.client;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.client.values.Address;
import org.example.minimarker.client.values.LocationId;

import java.util.Objects;

public class Location extends Entity<LocationId> {

    private Address address;

    public Location(LocationId entityId, Address address) {
        super(entityId);
        this.address = Objects.requireNonNull(address);
    }

    public void updateLocation(Address address){
        this.address = Objects.requireNonNull(address);
    }

    public Address address() {
        return address;
    }
}
