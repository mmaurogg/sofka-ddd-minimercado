package org.example.minimarker.client.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.NameClient;

public class UpdateNameCommand extends Command {

    private final ClientId clientId;
    private final NameClient name;

    public UpdateNameCommand(ClientId clientId, NameClient name) {
        this.clientId = clientId;
        this.name = name;
    }

    public NameClient getNameClient() {
        return name;
    }

    public ClientId getClientId() {
        return clientId;
    }
}
