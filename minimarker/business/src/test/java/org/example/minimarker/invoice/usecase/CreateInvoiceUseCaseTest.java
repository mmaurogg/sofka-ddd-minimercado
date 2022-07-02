package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.commands.CreateInvoiceCommand;
import org.example.minimarker.invoice.events.InvoiceCreated;
import org.example.minimarker.invoice.values.Date;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.NameAssessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.time.LocalDate.now;


@ExtendWith(MockitoExtension.class)
class CreateInvoiceUseCaseTest {

    @InjectMocks
    CreateInvoiceUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void whenInvoiceIsCreated(){
        //Arrange
        InvoiceId invoiceId = InvoiceId.of("iiii");
        NameAssessor name = new NameAssessor("Doe");
        ClientId clientId = ClientId.of("cccc");
        var command = new CreateInvoiceCommand( invoiceId,  name,  clientId);

        //Act - obtener los eventos
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents(); // devolverlos si los encontró

        // Assert
        var event =(InvoiceCreated)events.get(0); //evento que quiero evaluar
        Assertions.assertEquals("Doe", event.name().value());
        Assertions.assertEquals("cccc", event.clientId().value());
    }

}