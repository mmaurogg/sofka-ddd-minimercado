package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.product.Product;
import org.example.minimarker.product.commands.CreateProductCommand;
import org.example.minimarker.product.values.SupplierId;

public class CreateProductUseCase extends UseCase<RequestCommand<CreateProductCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateProductCommand> input) {
        var command = input.getCommand();
        var product = new Product(
                command.getProductId(),
                new SupplierId(),
                command.getNameSupplier(),
                command.getNameProduct(),
                command.getValueProduct()
        );

        emit().onResponse(new ResponseEvents(product.getUncommittedChanges()));
    }
}
