package org.example.minimarker.client.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.client.values.Balance;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.CreditId;

public class UpdateCreditBalanceCommand extends Command {

    private final ClientId clientId;
    private final CreditId creditId;
    private final Balance balance;

    public UpdateCreditBalanceCommand(ClientId clientId, CreditId creditId, Balance balance) {
        this.clientId = clientId;
        this.creditId = creditId;
        this.balance = balance;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public CreditId getCreditId() {
        return creditId;
    }

    public Balance getBalance() {
        return balance;
    }
}
