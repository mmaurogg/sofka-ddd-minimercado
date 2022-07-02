package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.Location;
import org.example.minimarker.client.values.NameClient;

public class ClientCreated extends DomainEvent {
    private final NameClient name;
    private final Location location;

    public ClientCreated(NameClient name, Location location) {
        super("sofka.client.clientcreated");
        this.name = name;
        this.location = location;
    }

    public NameClient name() {
        return name;
    }

    public Location location() {
        return location;
    }
}
