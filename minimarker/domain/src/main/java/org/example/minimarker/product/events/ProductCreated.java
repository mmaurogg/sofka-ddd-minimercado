package org.example.minimarker.product.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.ValueProduct;

public class ProductCreated extends DomainEvent {
    private final ProductId productId;
    private final Name name;
    private final ValueProduct valueProduct;

    public ProductCreated(ProductId productId, Name name, ValueProduct valueProduct) {
        super("sofka.product.productcreated");
        this.productId = productId;
        this.name = name;
        this.valueProduct = valueProduct;
    }

    public ProductId productId() {
        return productId;
    }

    public Name name() {
        return name;
    }

    public ValueProduct valueProduct() {
        return valueProduct;
    }
}
