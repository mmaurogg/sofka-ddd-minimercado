package org.example.minimarker.client;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.events.*;
import org.example.minimarker.client.values.*;

import java.util.List;
import java.util.Objects;

public class Client extends AggregateEvent<ClientId> {
    protected NameClient name;
    protected Classification classification;
    protected Location location;
    protected Credit credit;
    protected Account account;

    public Client(ClientId clientId, NameClient name, Location location) {
        super(clientId);
        appendChange(new ClientCreated(name, location)).apply();
        subscribe(new ClienChange(this));
    }

    private Client(ClientId clientId){
        super(clientId);
        subscribe(new ClienChange(this));
    }

    public static Client from (ClientId clientId, List<DomainEvent> events){
        var client = new Client(clientId);
        events.forEach(client::applyEvent);
        return client;
    }

    public void addAccount(String number, String type){
        Objects.requireNonNull(number);
        Objects.requireNonNull(type);
        appendChange(new AccountAdded(number, type)).apply();
    }
    public void calculateScore(ClassificationId classificationId, Score score){
        Objects.requireNonNull(score);
        appendChange(new ScoreCalculated(classificationId, score)).apply();
    }

    public void updateName (NameClient name){
        Objects.requireNonNull(name);
        appendChange(new NameUpdated(name)).apply();
    }

    public void updateCreditAmount (CreditId creditId, Amount amount){
        Objects.requireNonNull(amount);
        appendChange(new CreditAmountUpdated(creditId, amount)).apply();
    }

    public void updateCreditBalance(CreditId creditId, Balance balance){
        Objects.requireNonNull(balance);
        appendChange(new CreditBalanceUpdated(creditId, balance)).apply();
    }

    public void addAddressInLocation(LocationId locationId, Address address){
        Objects.requireNonNull(address);
        appendChange(new AddressInLocationAdded(locationId, address)).apply();
    }

    public void updateAddressInLocation(LocationId locationId, Address address){
        Objects.requireNonNull(address);
        appendChange(new AddressInLocationUpdated(locationId, address)).apply();
    }

}
