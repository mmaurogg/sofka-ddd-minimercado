package org.example.minimarker.client;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.Amount;
import org.example.minimarker.client.values.CreditId;

public class CreditAmountUpdated extends DomainEvent {
    private final CreditId creditId;
    private final Amount amount;

    public CreditAmountUpdated(CreditId creditId, Amount amount) {
        super("sofka.client.creditamountupdated");
        this.creditId = creditId;
        this.amount = amount;
    }

    public Amount amount() {
        return amount;
    }

    public CreditId creditId() {
        return creditId;
    }
}
