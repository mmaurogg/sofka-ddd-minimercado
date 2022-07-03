package org.example.minimarker.client.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.Client;
import org.example.minimarker.client.commands.CalculateScoreCommand;

public class CalculateScoreUseCase extends UseCase<RequestCommand<CalculateScoreCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CalculateScoreCommand> input) {
        var command = input.getCommand();
        var client = Client.from(
                command.getClientId(), repository().getEventsBy(command.getClientId().value())
        );

        client.calculateScore(command.getClassificationId(), command.getScore());

        emit().onResponse(new ResponseEvents(client.getUncommittedChanges()));
    }
}
