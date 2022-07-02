package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import org.example.minimarker.client.Client;
import org.example.minimarker.client.commands.CreateClientCommand;
import org.example.minimarker.client.events.ClientCreated;
import org.example.minimarker.client.values.Address;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.NameClient;
import org.example.minimarker.invoice.usecase.CreateInvoiceUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateClientUseCaseTest {

    @InjectMocks
    CreateClientUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void whenAClientIsCreated(){
        ClientId clientId = ClientId.of("cccc");
        NameClient name = new NameClient("ClienteUser");
        Address address = new Address("DireccionUser");
        var command = new CreateClientCommand(clientId, name, address);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var evet = (ClientCreated)events.get(0);
        Assertions.assertEquals("DireccionUser", evet.getAddress().value());
        Assertions.assertEquals("ClienteUser", evet.getName().value());
    }

}