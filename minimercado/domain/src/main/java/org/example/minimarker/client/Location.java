package org.example.minimarker.client;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.client.values.LocationId;

import java.util.Objects;

public class Location extends Entity<LocationId> {

    private Location location;

    public Location(LocationId entityId, Location location) {
        super(entityId);
        this.location = Objects.requireNonNull(location);
    }

    public void updateLocation(Location location){
        this.location = Objects.requireNonNull(location);
    }

    public Location location() {
        return location;
    }
}
