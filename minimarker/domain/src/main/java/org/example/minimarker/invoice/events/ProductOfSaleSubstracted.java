package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.invoice.values.SaleId;
import org.example.minimarker.product.Product;

public class ProductOfSaleSubstracted extends DomainEvent {
    private final SaleId saleId;
    private final Product product;

    public ProductOfSaleSubstracted(SaleId saleId, Product product) {
        super("sofka.Invoice.productofsalesubstracted");
        this.saleId = saleId;
        this.product = product;
    }

    public Product product() {
        return product;
    }

    public SaleId saleId() {
        return saleId;
    }
}
