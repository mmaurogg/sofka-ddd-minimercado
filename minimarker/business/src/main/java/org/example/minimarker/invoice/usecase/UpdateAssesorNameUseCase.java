package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.invoice.Invoice;
import org.example.minimarker.invoice.commands.UpdateAssesorNameCommand;

public class UpdateAssesorNameUseCase extends UseCase<RequestCommand<UpdateAssesorNameCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateAssesorNameCommand> input) {
        var command = input.getCommand();
        var invoice = Invoice.from(
                command.getInvoiceId(), repository().getEventsBy(command.getInvoiceId().value())
        );
        invoice.updateAssesorName(command.getAssessorId(), command.getName());

        emit().onResponse((new ResponseEvents(invoice.getUncommittedChanges())));
    }
}
