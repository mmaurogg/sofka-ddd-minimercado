package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.product.Product;
import org.example.minimarker.product.commands.UpdateStockOfSKUCommand;

public class UpdateStockOfSKUUSeCase extends UseCase<RequestCommand<UpdateStockOfSKUCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateStockOfSKUCommand> input) {
        var command = input.getCommand();
        var product = Product.from(
                command.getProductId(), repository().getEventsBy(command.getProductId().value())
        );

        product.updateStockOfSKU(command.getSkuId(), command.getStock());

        emit().onResponse(new ResponseEvents(product.getUncommittedChanges()));
    }
}
