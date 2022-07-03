package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.commands.UpdateAddressInLocationCommand;
import org.example.minimarker.client.events.AddressInLocationUpdated;
import org.example.minimarker.client.events.ClientCreated;
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
class UpdateAddressInLocationIUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    UpdateAddressInLocationUseCase useCase;

    @Test
    public void whenAddressInLocationIsUpdated(){
        ClientId clientId = ClientId.of("client1");
        LocationId locationId = LocationId.of("locationId");
        Address address = new Address("calle 0 con 0");

        var command = new UpdateAddressInLocationCommand(clientId, locationId, address);
        when(repository.getEventsBy(clientId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AddressInLocationUpdated)events.get(0);
        Assertions.assertEquals("calle 0 con 0", event.address().value());

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