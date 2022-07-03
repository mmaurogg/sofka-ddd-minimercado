package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import org.example.minimarker.client.Client;
import org.example.minimarker.client.commands.UpdateAddressInLocationCommand;

import co.com.sofka.business.support.ResponseEvents;

public class UpdateAddressInLocationUseCase extends UseCase<RequestCommand<UpdateAddressInLocationCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateAddressInLocationCommand> input) {
        var command = input.getCommand();
        var client = Client.from(
                command.getClientId(), repository().getEventsBy(command.getClientId().value())
        );

        client.updateAddressInLocation(command.getLocationId(), command.getAddress());

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }
}
