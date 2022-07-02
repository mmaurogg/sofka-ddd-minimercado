package org.example.minimarker.client;

import co.com.sofka.domain.generic.EventChange;
import org.example.minimarker.client.events.*;
import org.example.minimarker.client.values.Account;
import org.example.minimarker.client.values.Amount;
import org.example.minimarker.client.values.ClassificationId;
import org.example.minimarker.client.values.CreditId;

import java.util.Objects;

public class ClienChange extends EventChange {

    public ClienChange(Client client){

        apply((ClientCreated event)->{
            client.name = event.name();
            try {
                client.credit = new Credit(new CreditId(), new Amount(0.0));
                client.classification = new Classification(new ClassificationId());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            client.location = event.location();
        });

        apply((ScoreCalculated event) ->{
            client.calculateScore(event.classificationId(), event.score());
        });

        apply((AccountAdded event)->{
            client.addAccount(event.number(), event.type());

        });

        apply((AddressInLocationAdded event)->{
            client.addAddressInLocation(event.locationId(), event.address());
        });

        apply((AddressInLocationUpdated event)->{
            client.updateAddressInLocation(event.locationId(),event.address());
        });

        apply((NameUpdated event)->{
            client.updateName(event.name());
        });

        apply((CreditAmountUpdated event)->{
            client.updateCreditAmount(event.creditId(), event.amount());
        });

        apply((CreditBalanceUpdated event)->{
            client.updateCreditBalance(event.creditId(), event.balance());
        });

    }

}
