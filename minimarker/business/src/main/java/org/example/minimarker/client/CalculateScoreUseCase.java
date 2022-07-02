package org.example.minimarker.client;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.commands.CalculateScoreCommand;

public class CalculateScoreUseCase extends UseCase<RequestCommand<CalculateScoreCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CalculateScoreCommand> input) {

    }
}
