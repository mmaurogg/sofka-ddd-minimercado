package org.example.minimarker.client;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.Account;

public class AccountAdded extends DomainEvent {
    private final Account account;

    public AccountAdded(Account account) {
        super("sofka.client.accountadded");
        this.account = account;
    }

    public Account account() {
        return account;
    }
}
