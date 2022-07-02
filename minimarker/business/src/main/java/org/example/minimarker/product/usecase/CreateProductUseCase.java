package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.product.commands.CreateProductCommand;

public class CreateProductUseCase extends UseCase<RequestCommand<CreateProductCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateProductCommand> input) {
        var command = input.getCommand();
        var invoice = new Invoice(
                command.getProductId(),

        );
    }
}
