package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.Client;
import org.example.minimarker.client.commands.UpdateCreditBalanceCommand;

public class UpdateBalanceUseCase extends UseCase<RequestCommand<UpdateCreditBalanceCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateCreditBalanceCommand> input) {
        var command = input.getCommand();
        var client = Client.from(
                command.getClientId(), repository().getEventsBy(command.getClientId().value())
        );

        client.updateCreditBalance(command.getCreditId(), command.getBalance());

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }
}
