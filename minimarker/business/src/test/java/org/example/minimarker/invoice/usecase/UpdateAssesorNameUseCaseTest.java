package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.commands.UpdateAssesorNameCommand;
import org.example.minimarker.invoice.events.AssesorNameUpdated;
import org.example.minimarker.invoice.events.InvoiceCreated;
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
class UpdateAssesorNameUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    UpdateAssesorNameUseCase useCase;

    @Test
    public void whenAssessorNameIsUpdated(){
        InvoiceId invoiceId = InvoiceId.of("invoiceId");
        AssessorId assessorId = AssessorId.of("assessorId");
        NameAssessor nameAssessor = new NameAssessor("new name assessor");

        var command = new UpdateAssesorNameCommand(invoiceId, assessorId,nameAssessor);
        when(repository.getEventsBy(invoiceId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AssesorNameUpdated)events.get(0);
        Assertions.assertEquals("new name assessor", event.name().value());
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