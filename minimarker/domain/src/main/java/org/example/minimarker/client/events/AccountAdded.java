package org.example.minimarker.client.events;

import co.com.sofka.domain.generic.DomainEvent;

public class AccountAdded extends DomainEvent {

    private final String number;
    private final String type;

    public AccountAdded(String number, String type) {
        super("sofka.client.accountadded");

        this.number = number;
        this.type = type;
    }

    public String number() {
        return number;
    }

    public String type() {
        return type;
    }
}
