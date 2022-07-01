package org.example.minimarker.client;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.Address;
import org.example.minimarker.client.values.LocationId;

public class AddressInLocationAdded extends DomainEvent {
    private final LocationId locationId;
    private final Address address;

    public AddressInLocationAdded(LocationId locationId, Address address) {
        super("sofka.client.addressinlocationadded");
        this.locationId = locationId;
        this.address = address;
    }

    public Address address() {
        return address;
    }

    public LocationId locationId() {
        return locationId;
    }
}
