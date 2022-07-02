package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.invoice.commands.CreateInvoiceCommand;
import org.example.minimarker.invoice.values.AssessorId;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.NameAssessor;
import org.example.minimarker.invoice.values.SaleId;

public class CreateInvoiceUseCase extends UseCase<RequestCommand<CreateInvoiceCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateInvoiceCommand> input) {
        var command = input.getCommand();
        var invoice = new Invoice(
                command.getInvoiceId(),
                new SaleId(),
                new AssessorId(),
                command.getName(),
                command.getClientId()
        );

        //Pasar eventos que quedaron pendientes
        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));
    }
}
