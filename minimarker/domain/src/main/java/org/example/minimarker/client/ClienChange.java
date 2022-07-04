package org.example.minimarker.client;

import co.com.sofka.domain.generic.EventChange;
import org.example.minimarker.client.events.*;
import org.example.minimarker.client.values.*;

public class ClienChange extends EventChange {

    public ClienChange(Client client){

        apply((ClientCreated event)->{
            client.name = event.getName();
            client.location = new Location(event.getLocationId(), event.getAddress());
            client.account = null;
            try {
                client.classification = new Classification(new ClassificationId());
                client.credit = new Credit(new CreditId(), new Amount(0.0));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        apply((AccountAdded event)->{
            try {
                client.account = new Account(event.number(), event.type());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        apply((AddressInLocationUpdated event)->{
            client.location.updateLocation(event.address());
        });

        apply((NameUpdated event)->{
            client.name = new NameClient(event.nameClient().value());
        });

        apply((CreditAmountUpdated event)->{
            client.credit.updateAmount(event.amount());
        });

        apply((CreditBalanceUpdated event)->{
            client.credit.updateBalance(event.balance());
        });

        apply((ScoreCalculated event) ->{
            client.classification.updateScore(event.score());
        });
    }

}
