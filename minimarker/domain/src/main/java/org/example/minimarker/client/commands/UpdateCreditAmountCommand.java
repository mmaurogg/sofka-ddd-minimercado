package org.example.minimarker.client.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.client.values.Amount;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.CreditId;

public class UpdateCreditAmountCommand extends Command {

    private final ClientId clientId;
    private final CreditId creditId;
    private final Amount amount;

    public UpdateCreditAmountCommand(ClientId clientId, CreditId creditId, Amount amount) {
        this.clientId = clientId;
        this.creditId = creditId;
        this.amount = amount;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public CreditId getCreditId() {
        return creditId;
    }

    public Amount getAmount() {
        return amount;
    }
}
