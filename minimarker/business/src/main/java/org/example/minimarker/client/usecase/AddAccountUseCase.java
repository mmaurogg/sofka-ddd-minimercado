package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.Client;
import org.example.minimarker.client.commands.AddAccountCommand;

public class AddAccountUseCase extends UseCase<RequestCommand<AddAccountCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddAccountCommand> input) {
        var command = input.getCommand();
        var client = Client.from(
                command.getClientId(), repository().getEventsBy(command.getClientId().value())
        );

        client.addAccount(command.getNumber(), command.getType());

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }
}
