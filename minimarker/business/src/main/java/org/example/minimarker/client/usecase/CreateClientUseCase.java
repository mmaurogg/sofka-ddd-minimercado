package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.Client;
import org.example.minimarker.client.commands.CreateClientCommand;
import org.example.minimarker.client.values.LocationId;

public class CreateClientUseCase extends UseCase<RequestCommand<CreateClientCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateClientCommand> input) {
        var command = input.getCommand();
        var client = new Client(
                command.getClientId(),
                command.getName(),
                new LocationId(),
                command.getAddress()
        );

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }
}
