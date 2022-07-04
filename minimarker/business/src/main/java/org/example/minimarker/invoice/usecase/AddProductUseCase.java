package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.invoice.commands.AddProductToSaleCommand;

public class AddProductUseCase extends UseCase<RequestCommand<AddProductToSaleCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProductToSaleCommand> input) {
        var command = input.getCommand();
        var invoice = Invoice.from(
                command.getInvoiceId(), repository().getEventsBy(command.getInvoiceId().value())
        );
        invoice.addProductToSale(command.getSaleId(), command.getProductId(), command.getValueProduct());

        emit().onResponse((new ResponseEvents(invoice.getUncommittedChanges())));
    }
}
