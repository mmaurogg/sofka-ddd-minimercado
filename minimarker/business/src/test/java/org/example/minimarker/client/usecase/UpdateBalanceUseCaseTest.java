package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.commands.UpdateCreditBalanceCommand;
import org.example.minimarker.client.events.ClientCreated;
import org.example.minimarker.client.events.CreditBalanceUpdated;
import org.example.minimarker.client.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateBalanceUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    UpdateBalanceUseCase useCase;

    @Test
    public void whenBalanceInCreditIsUpdated(){
        ClientId clientId = ClientId.of("client1");
        CreditId creditId = CreditId.of("creditId");
        Balance balance = new Balance(9.0);

        var command = new UpdateCreditBalanceCommand(clientId, creditId, balance);
        when(repository.getEventsBy(clientId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CreditBalanceUpdated)events.get(0);
        assertEquals(9.0, event.balance().value());
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