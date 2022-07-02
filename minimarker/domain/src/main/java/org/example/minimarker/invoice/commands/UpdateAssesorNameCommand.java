package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.invoice.values.AssessorId;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.NameAssessor;

public class UpdateAssesorNameCommand extends Command {

    private final InvoiceId invoiceId;
    private final AssessorId assessorId;
    private final NameAssessor name;

    public UpdateAssesorNameCommand(InvoiceId invoiceId, AssessorId assessorId, NameAssessor name) {
        this.invoiceId = invoiceId;
        this.assessorId = assessorId;
        this.name = name;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public AssessorId getAssessorId() {
        return assessorId;
    }

    public NameAssessor getName() {
        return name;
    }
}
