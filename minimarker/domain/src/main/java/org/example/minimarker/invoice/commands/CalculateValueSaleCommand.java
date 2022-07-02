package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.SaleId;

public class CalculateValueSaleCommand extends Command {

    private final InvoiceId invoiceId;
    private final SaleId saleId;

    public CalculateValueSaleCommand(InvoiceId invoiceId, SaleId saleId) {
        this.invoiceId = invoiceId;
        this.saleId = saleId;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public SaleId getSaleId() {
        return saleId;
    }
}
