package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.commands.UpdatePaymentValueCommand;
import org.example.minimarker.invoice.events.InvoiceCreated;
import org.example.minimarker.invoice.events.PaymentAdded;
import org.example.minimarker.invoice.events.PaymentValueUpdated;
import org.example.minimarker.invoice.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateValueCaseUseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    UpdateValueCaseUse useCase;

    @Test
    public void whenPaymentValueIsUpdated(){
        InvoiceId invoiceId = InvoiceId.of("invoiceId");
        PaymentId paymentId = PaymentId.of("paymentId");
        Value value = new Value(400.0);

        var command = new UpdatePaymentValueCommand(invoiceId, paymentId,value);
        when(repository.getEventsBy(invoiceId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PaymentValueUpdated)events.get(0);
        Assertions.assertEquals(400.0, event.value().value());
    }

    private List<DomainEvent> history() {
        SaleId saleId = SaleId.of("saleId");
        AssessorId assessorId = AssessorId.of("assesorId");
        NameAssessor name = new NameAssessor("Doe");
        ClientId clientId = ClientId.of("cccc");

        PaymentId paymentId = PaymentId.of("paymentId");
        Method method = new Method("method of payment");
        Value value = new Value(134.0);

        return List.of(
                new InvoiceCreated(saleId, assessorId, name, clientId),
                new PaymentAdded(paymentId, method, value)
        );
    }

}