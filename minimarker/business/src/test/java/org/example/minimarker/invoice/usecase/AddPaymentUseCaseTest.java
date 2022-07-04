package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.commands.AddPaymentCommand;
import org.example.minimarker.invoice.events.InvoiceCreated;
import org.example.minimarker.invoice.events.PaymentAdded;
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
class AddPaymentUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AddPaymentUseCase useCase;

    @Test
    public void whenPaymenIsAdd(){
        InvoiceId invoiceId = InvoiceId.of("invoiceId");
        PaymentId paymentId = PaymentId.of("paymentId");
        Method method = new Method("method of payment");
        Value value = new Value(134.0);

        var command = new AddPaymentCommand(invoiceId, paymentId, method, value);
        when(repository.getEventsBy(invoiceId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PaymentAdded)events.get(0);
        Assertions.assertEquals("method of payment", event.method().value());
        Assertions.assertEquals(134.0, event.value().value());
    }

    private List<DomainEvent> history() {
        SaleId saleId = SaleId.of("saleId");
        AssessorId assessorId = AssessorId.of("assesorId");
        NameAssessor name = new NameAssessor("Doe");
        ClientId clientId = ClientId.of("cccc");

        return List.of(
                new InvoiceCreated(saleId, assessorId, name, clientId)
        );
    }

}