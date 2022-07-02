package org.example.minimarker.client.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.client.values.ClientId;

public class AddAccountCommand extends Command {

    private final ClientId clientId;
    private final String number;
    private final String type;

    public AddAccountCommand(ClientId clientId, String number, String type) {
        this.clientId = clientId;
        this.number = number;
        this.type = type;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }
}
