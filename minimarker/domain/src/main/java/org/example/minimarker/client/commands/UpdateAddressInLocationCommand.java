package org.example.minimarker.client.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.client.values.Address;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.LocationId;

public class UpdateAddressInLocationCommand extends Command {
    private final ClientId clientId;
    private final LocationId locationId;
    private final Address address;

    public UpdateAddressInLocationCommand(ClientId clientId, LocationId locationId, Address address) {
        this.clientId = clientId;
        this.locationId = locationId;
        this.address = address;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public LocationId getLocationId() {
        return locationId;
    }

    public Address getAddress() {
        return address;
    }
}
