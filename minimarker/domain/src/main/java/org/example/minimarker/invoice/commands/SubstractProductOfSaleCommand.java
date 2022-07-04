package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.SaleId;
import org.example.minimarker.product.values.ProductId;

public class SubstractProductOfSaleCommand extends Command {

    private final InvoiceId invoiceId;
    private final SaleId saleId;
    private final ProductId productId;

    public SubstractProductOfSaleCommand(InvoiceId invoiceId, SaleId saleId, ProductId productId) {
        this.invoiceId = invoiceId;
        this.saleId = saleId;
        this.productId = productId;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public ProductId getProductId() {
        return productId;
    }
}
