package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.invoice.commands.SubstractProductOfSaleCommand;

public class SubstractProductOfSaleUseCase extends UseCase<RequestCommand<SubstractProductOfSaleCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<SubstractProductOfSaleCommand> input) {
        var command = input.getCommand();
        var invoice = Invoice.from(
                command.getInvoiceId(), repository().getEventsBy(command.getInvoiceId().value())
        );
        invoice.substractProductOfSale(command.getSaleId(), command.getProductId());

        emit().onResponse((new ResponseEvents(invoice.getUncommittedChanges())));
    }
}
