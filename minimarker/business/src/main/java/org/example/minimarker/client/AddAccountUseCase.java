package org.example.minimarker.client;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.commands.AddAccountCommand;
import org.example.minimarker.client.values.Account;

public class AddAccountUseCase extends UseCase<RequestCommand<AddAccountCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAccountCommand> input) {
        var command = input.getCommand();
        var client = Client.from(
                command.getClientId(),
                repository().getEventsBy(command.getClientId().value())
                );

        try {
            client.account  = new Account(command.getNumber(), command.getType());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }
}
