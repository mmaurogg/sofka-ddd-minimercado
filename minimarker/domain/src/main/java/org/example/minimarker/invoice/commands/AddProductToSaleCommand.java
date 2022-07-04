package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.SaleId;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.ValueProduct;

public class AddProductToSaleCommand extends Command {

    private final InvoiceId invoiceId;
    private final SaleId saleId;
    private final ProductId productId;

    private final ValueProduct valueProduct;

    public AddProductToSaleCommand(InvoiceId invoiceId, SaleId saleId, ProductId productId, ValueProduct valueProduct) {
        this.invoiceId = invoiceId;
        this.saleId = saleId;
        this.productId = productId;
        this.valueProduct = valueProduct;
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

    public ValueProduct getValueProduct() {
        return valueProduct;
    }
}
