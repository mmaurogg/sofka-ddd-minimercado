package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.invoice.values.SaleId;
import org.example.minimarker.product.Product;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.ValueProduct;

public class ProductToSaleAdded extends DomainEvent {
    private final SaleId saleId;
    private final ProductId productId;

    private final ValueProduct valueProduct;

    public ProductToSaleAdded(SaleId saleId, ProductId productId, ValueProduct valueProduct) {
        super("sofka.Invoice.producttosaleAdded");
        this.saleId = saleId;
        this.productId = productId;
        this.valueProduct = valueProduct;
    }

    public ProductId productId() {
        return productId;
    }

    public SaleId saleId() {
        return saleId;
    }

    public ValueProduct getValueProduct() {
        return valueProduct;
    }
}

