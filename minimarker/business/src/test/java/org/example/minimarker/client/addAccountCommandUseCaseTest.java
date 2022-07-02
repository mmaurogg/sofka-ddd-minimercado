package org.example.minimarker.client;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.commands.AddAccountCommand;
import org.example.minimarker.client.events.AccountAdded;
import org.example.minimarker.client.events.ClientCreated;
import org.example.minimarker.client.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddAccountUseCaseTest {

    @InjectMocks
    AddAccountUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void whenAddAccount() {

        ClientId clientId = ClientId.of("xxxx");
        String number = "12345678";
        String type = "tttt";


        var command = new AddAccountCommand(clientId, number, type);

        //historico
        when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (AccountAdded)events.get(0);
        Assertions.assertEquals("12345678", event.number());

    }

    private List<DomainEvent> history(){
        return List.of(new ClientCreated(
                new NameClient("Mao"), new Location(new LocationId(), new Address("lllllll"))
        ));
    }

}