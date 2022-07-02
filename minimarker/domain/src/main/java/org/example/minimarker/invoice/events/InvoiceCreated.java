package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.values.AssessorId;
import org.example.minimarker.invoice.values.NameAssessor;
import org.example.minimarker.invoice.values.SaleId;

public class InvoiceCreated extends DomainEvent {

    private final SaleId saleId;
    private final AssessorId assessorId;
    private final NameAssessor name;
    private final ClientId clientId;

    public InvoiceCreated(SaleId saleId, AssessorId assessorId, NameAssessor name, ClientId clientId) {
        super("sofka.invoice.invoicecreated");
        this.saleId = saleId;
        this.assessorId = assessorId;
        this.name = name;
        this.clientId = clientId;
    }

    public SaleId saleId() {
        return saleId;
    }

    public AssessorId assessorId() {
        return assessorId;
    }

    public ClientId clientId() {
        return clientId;
    }

    public NameAssessor name() {
        return name;
    }
}
