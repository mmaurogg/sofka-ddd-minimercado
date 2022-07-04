package org.example.minimarker.events;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.minimarker.client.events.ClientCreated;
import org.example.minimarker.client.values.ClientId;

import java.util.List;

public class NotificactionWhenClientIsCreatedUseCase extends UseCase<TriggeredEvent<ClientCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ClientCreated> input) {

        var event = input.getDomainEvent();

        var service = getService(EmailService.class).orElseThrow();

        String body = String.format(event.getName().value() + " Has sido creado como cliente");
        service.sendEmail(new ClientId("clienteId"), body);

        emit().onResponse((new ResponseEvents((List.of()))));
    }
}
