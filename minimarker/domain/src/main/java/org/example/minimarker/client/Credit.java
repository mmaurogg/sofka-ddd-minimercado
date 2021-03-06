package org.example.minimarker.client;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.client.values.Amount;
import org.example.minimarker.client.values.Balance;
import org.example.minimarker.client.values.CreditId;
import org.example.minimarker.client.values.Score;

import java.util.Objects;

public class Credit extends Entity<CreditId> {

    private Amount amount;
    private Balance balance;

    public Credit(CreditId creditId, Amount amount) {
        super(creditId);
        this.amount = Objects.requireNonNull(amount);
        this.balance = new Balance(0.0);
    }

    public void updateAmount(Amount amount){
        this.amount = Objects.requireNonNull(amount);
    }

    public void updateBalance(Balance balance){
        this.balance = Objects.requireNonNull(balance);
    }

    public Amount amount() {
        return amount;
    }

    public Balance balance() {
        return balance;
    }
}
