package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.invoice.commands.CalculateValueSaleCommand;

public class CalculateValueSaleUseCase extends UseCase<RequestCommand<CalculateValueSaleCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CalculateValueSaleCommand> input) {
        var command = input.getCommand();
        var invoice = Invoice.from(
                command.getInvoiceId(), repository().getEventsBy(command.getInvoiceId().value())
        );
        invoice.calculateValueSale(command.getSaleId());

        emit().onResponse((new ResponseEvents(invoice.getUncommittedChanges())));
    }
}
