package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.NameAssessor;

public class CreateInvoiceCommand extends Command {

    private final InvoiceId invoiceId;
    private final NameAssessor name;
    private final ClientId clientId;

    public CreateInvoiceCommand(InvoiceId invoiceId, NameAssessor name, ClientId clientId) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.clientId = clientId;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public NameAssessor getName() {
        return name;
    }
}

