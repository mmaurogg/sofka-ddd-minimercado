package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.Address;
import org.example.minimarker.client.values.LocationId;
import org.example.minimarker.client.values.NameClient;

public class ClientCreated extends DomainEvent {

    private final NameClient name;
    private final LocationId locationId;
    private final Address address;

    public ClientCreated(NameClient name, LocationId locationId, Address address) {
        super("org.example.minimarker.client.clientcreated");

        this.name = name;
        this.locationId = locationId;
        this.address = address;
    }

    public NameClient getName() {
        return name;
    }

    public LocationId getLocationId() {
        return locationId;
    }

    public Address getAddress() {
        return address;
    }
}
