package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.Balance;
import org.example.minimarker.client.values.CreditId;

public class CreditBalanceUpdated extends DomainEvent {
    private final CreditId creditId;
    private final Balance balance;

    public CreditBalanceUpdated(CreditId creditId, Balance balance) {
        super("org.example.minimarker.client.creditbalanceupdated");
        this.creditId = creditId;
        this.balance = balance;
    }

    public Balance balance() {
        return balance;
    }

    public CreditId creditId() {
        return creditId;
    }
}
