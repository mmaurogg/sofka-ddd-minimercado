package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.Client;
import org.example.minimarker.client.commands.UpdateNameCommand;

public class UpdateNameUseCase extends UseCase<RequestCommand<UpdateNameCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateNameCommand> input) {
        var command = input.getCommand();
        var client = Client.from(
                command.getClientId(), repository().getEventsBy(command.getClientId().value())
        );

        client.updateName(command.getNameClient());

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }
}
