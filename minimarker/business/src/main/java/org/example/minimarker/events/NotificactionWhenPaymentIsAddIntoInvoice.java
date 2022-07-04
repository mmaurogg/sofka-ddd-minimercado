package org.example.minimarker.events;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.minimarker.client.events.ClientCreated;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.events.PaymentAdded;

import java.util.List;

public class NotificactionWhenPaymentIsAddIntoInvoice extends UseCase<TriggeredEvent<PaymentAdded>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PaymentAdded> input) {

        var event = input.getDomainEvent();

        var service = getService(EmailService.class).orElseThrow();

        String body = String.format("Ha pagado "+ event.value().value() + " con "+ event.method().value());
        service.sendEmail(new ClientId("clienteId"), body);

        emit().onResponse((new ResponseEvents((List.of()))));
    }
}
