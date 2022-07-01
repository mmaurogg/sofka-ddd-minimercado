package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.NameClient;

public class ClientCreated extends DomainEvent {
    private final NameClient name;

    public ClientCreated(NameClient name) {
        super("sofka.client.clientcreated");
        this.name = name;
    }

    public NameClient name() {
        return name;
    }
}
