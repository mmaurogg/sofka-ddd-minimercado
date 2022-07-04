package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.invoice.commands.AddPaymentCommand;

public class AddPaymentUseCase extends UseCase<RequestCommand<AddPaymentCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPaymentCommand> input) {
        var command = input.getCommand();
        var invoice = Invoice.from(
                command.getInvoiceId(), repository().getEventsBy(command.getInvoiceId().value())
        );
        invoice.addPayment(command.getPaymentId(), command.getMethod(), command.getValue());

        emit().onResponse((new ResponseEvents(invoice.getUncommittedChanges())));
    }
}
