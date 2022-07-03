package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.Client;
import org.example.minimarker.client.commands.UpdateCreditAmountCommand;

public class UpdateCreditAmountUseCase extends UseCase<RequestCommand<UpdateCreditAmountCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateCreditAmountCommand> input) {
        var command = input.getCommand();
        var client = Client.from(
                command.getClientId(), repository().getEventsBy(command.getClientId().value())
        );

        client.updateCreditAmount(command.getCreditId(), command.getAmount());

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }
}
