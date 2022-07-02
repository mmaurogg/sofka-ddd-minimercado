package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.NameClient;

public class NameUpdated extends DomainEvent {
    private final NameClient name;

    public NameUpdated(NameClient name) {
        super("sofka.client.nameupdated");
        this.name = name;
    }

    public NameClient name() {
        return name;
    }
}
