package org.example.minimarker.client.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.client.values.Address;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.NameClient;

public class CreateClientCommand extends Command {

    private final ClientId clientId;
    private final NameClient name;
    private final Address address;

    public CreateClientCommand(ClientId clientId, NameClient name, Address address) {
        this.clientId = clientId;
        this.name = name;
        this.address = address;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public NameClient getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
