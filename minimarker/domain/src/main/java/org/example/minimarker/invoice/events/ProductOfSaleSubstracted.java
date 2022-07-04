package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.invoice.values.SaleId;
import org.example.minimarker.product.values.ProductId;

public class ProductOfSaleSubstracted extends DomainEvent {
    private final SaleId saleId;
    private final ProductId productId;

    public ProductOfSaleSubstracted(SaleId saleId, ProductId productId) {
        super("sofka.Invoice.productofsalesubstracted");
        this.saleId = saleId;
        this.productId = productId;
    }

    public ProductId productId() {
        return productId;
    }

    public SaleId saleId() {
        return saleId;
    }
}
