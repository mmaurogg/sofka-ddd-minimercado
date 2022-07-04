package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.commands.UpdateNameCommand;
import org.example.minimarker.client.events.ClientCreated;
import org.example.minimarker.client.events.NameUpdated;
import org.example.minimarker.client.values.Address;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.client.values.LocationId;
import org.example.minimarker.client.values.NameClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateNameUSeCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    UpdateNameUseCase useCase;

    @Test
    public void whenNameOfClientIsUpdated(){
        ClientId clientId = ClientId.of("client1");
        NameClient name = new NameClient("NewNAmeClient");

        var command = new UpdateNameCommand(clientId, name);
        when(repository.getEventsBy(clientId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NameUpdated)events.get(0);
        Assertions.assertEquals("NewNAmeClient", event.nameClient().value());
    }

    private List<DomainEvent> history() {
        NameClient name = new NameClient("ClienteUser");
        LocationId locationId = LocationId.of("locationId");
        Address address = new Address("DireccionUser");

        return List.of(
                new ClientCreated(name, locationId, address)
        );
    }

}