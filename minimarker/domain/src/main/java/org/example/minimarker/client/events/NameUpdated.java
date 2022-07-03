package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.NameClient;

public class NameUpdated extends DomainEvent {
    private final NameClient name;

    public NameUpdated(NameClient name) {
        super("org.example.minimarker.client.nameupdated");
        this.name = name;
    }

    public NameClient nameClient() {
        return name;
    }
}
