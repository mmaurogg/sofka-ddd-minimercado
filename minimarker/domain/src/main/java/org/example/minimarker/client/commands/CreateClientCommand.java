package org.example.minimarker.client.commands;

import org.example.minimarker.client.Location;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.NameClient;

public class CreateClientCommand {

    private final ClientId clientId;
    private final NameClient name;
    private final Location location;

    public CreateClientCommand(ClientId clientId, NameClient name, Location location) {
        this.clientId = clientId;
        this.name = name;
        this.location = location;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public NameClient getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
