package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.product.Product;
import org.example.minimarker.product.commands.UpdateNameOfSupplierCommand;

public class UpdateNameOfSupplierUseCase extends UseCase<RequestCommand<UpdateNameOfSupplierCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateNameOfSupplierCommand> input) {

        var command = input.getCommand();
        var product = Product.from(
                command.getProductId(), repository().getEventsBy(command.getProductId().value())
                );

        product.updateNameOfSupplier( command.getSupplierId(), command.getNameSupplier());

        emit().onResponse(new ResponseEvents(product.getUncommittedChanges()));

    }
}
