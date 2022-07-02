package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.SaleId;
import org.example.minimarker.product.Product;

public class SubstractProductOfSaleCommand extends Command {

    private final InvoiceId invoiceId;
    private final SaleId saleId;
    private final Product product;

    public SubstractProductOfSaleCommand(InvoiceId invoiceId, SaleId saleId, Product product) {
        this.invoiceId = invoiceId;
        this.saleId = saleId;
        this.product = product;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public Product getProduct() {
        return product;
    }
}
