package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.invoice.commands.UpdatePaymentMethodCommand;
import org.example.minimarker.invoice.values.AssessorId;
import org.example.minimarker.invoice.values.SaleId;

public class UpdatePaymentMethodUseCase extends UseCase<RequestCommand<UpdatePaymentMethodCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePaymentMethodCommand> input) {
        var command = input.getCommand();
        var invoice = Invoice.from(
                command.getInvoiceId(), repository().getEventsBy(command.getInvoiceId().value())
        );
        invoice.updatePaymentMethod(command.getPaymentId(), command.getMethod());

        emit().onResponse((new ResponseEvents(invoice.getUncommittedChanges())));
    }
}
