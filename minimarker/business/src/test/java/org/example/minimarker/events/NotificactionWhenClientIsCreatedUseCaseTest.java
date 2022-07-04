package org.example.minimarker.events;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificactionWhenClientIsCreatedUseCaseTest {

    @Mock
    EmailService service;

    @InjectMocks
    NotificactionWhenClientIsCreatedUseCase useCase;

    @Test
    public void sendEmail(){
        var event = new ClientCreated( new NameClient("Jhon Doe"), LocationId.of("locationId"), new Address("avenida siempre viva"));
        Mockito.doNothing().when(service).sendEmail(ClientId.of("clienteId"), "Jhon Doe Has sido creado como cliente");
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Assertions.assertEquals(0, events.size());
    }

}