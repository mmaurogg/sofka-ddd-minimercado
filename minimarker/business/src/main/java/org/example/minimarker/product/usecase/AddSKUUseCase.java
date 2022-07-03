package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.product.Product;
import org.example.minimarker.product.commands.AddSKUCommand;

public class AddSKUUseCase extends UseCase<RequestCommand<AddSKUCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSKUCommand> input) {
        var command = input.getCommand();
        var product = Product.from(
                command.getProductId(), repository().getEventsBy(command.getProductId().value())
        );

        product.AddSKU(command.getSkuId(), command.getPlace(), command.getStock());

        emit().onResponse(new ResponseEvents(product.getUncommittedChanges()));
    }
}
