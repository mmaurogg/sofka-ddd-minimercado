package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.Address;
import org.example.minimarker.client.values.LocationId;

public class AddressInLocationUpdated extends DomainEvent {
    private final LocationId locationId;
    private final Address address;

    public AddressInLocationUpdated(LocationId locationId, Address address) {
        super("sofka.client.addressinlocationupdated");
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
