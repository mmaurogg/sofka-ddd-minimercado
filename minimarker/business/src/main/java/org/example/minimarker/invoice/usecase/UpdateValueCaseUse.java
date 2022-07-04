package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.invoice.commands.UpdatePaymentValueCommand;

public class UpdateValueCaseUse extends UseCase<RequestCommand<UpdatePaymentValueCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePaymentValueCommand> input) {
        var command = input.getCommand();
        var invoice = Invoice.from(
                command.getInvoiceId(), repository().getEventsBy(command.getInvoiceId().value())
        );
        invoice.updatePaymentValue(command.getPaymentId(), command.getValue());

        emit().onResponse((new ResponseEvents(invoice.getUncommittedChanges())));
    }
}
