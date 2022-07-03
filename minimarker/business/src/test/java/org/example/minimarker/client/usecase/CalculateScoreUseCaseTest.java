package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.commands.CalculateScoreCommand;
import org.example.minimarker.client.events.ClientCreated;
import org.example.minimarker.client.events.ScoreCalculated;
import org.example.minimarker.client.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateScoreUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CalculateScoreUseCase useCase;

    @Test
    public void whenScoreIsCalculated() throws IllegalAccessException {
        ClientId clientId = ClientId.of("client1");
        ClassificationId classificationId = ClassificationId.of("clasificacionId");
        Score score = new Score(2.0);

        var command = new CalculateScoreCommand(clientId, classificationId, score);
        when(repository.getEventsBy(clientId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ScoreCalculated)events.get(0);
        Assertions.assertEquals(2.0,  event.score().value());
    }

    private List<DomainEvent> history() throws IllegalAccessException {
        NameClient name = new NameClient("ClienteUser");
        LocationId locationId = LocationId.of("locationId");
        Address address = new Address("DireccionUser");

        ClassificationId classificationId = ClassificationId.of("clasificacionId");
        Score oldScore = new Score(1.0);
        return List.of(
                new ClientCreated(name, locationId, address),
                new ScoreCalculated(classificationId, oldScore)
        );
    }

}