package org.example.minimarker.client;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.commands.AddAddressInLocationCommand;

public class AddAddressInLocationUseCase extends UseCase<RequestCommand<AddAddressInLocationCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAddressInLocationCommand> input) {
        var command = input.getCommand();
        var client = Client.from(
                command.getClientId(),
                repository().getEventsBy(command.getLocationId().value())
        );

        client.addAddressInLocation(command.getLocationId(), command.getAddress());

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }

}
