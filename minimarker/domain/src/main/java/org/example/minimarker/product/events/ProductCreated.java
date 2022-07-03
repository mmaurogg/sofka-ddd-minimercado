package org.example.minimarker.product.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.SupplierId;
import org.example.minimarker.product.values.ValueProduct;

public class ProductCreated extends DomainEvent {
    private final SupplierId supplierId;
    private final Name nameSupplier;
    private final Name nameProduct;
    private final ValueProduct valueProduct;

    public ProductCreated(SupplierId supplierId, Name nameSupplier, Name nameProduct, ValueProduct valueProduct) {
        super("sofka.product.productcreated");
        this.supplierId = supplierId;
        this.nameSupplier = nameSupplier;
        this.nameProduct = nameProduct;
        this.valueProduct = valueProduct;
    }

    public SupplierId getSupplierId() {
        return supplierId;
    }

    public Name getNameSupplier() {
        return nameSupplier;
    }

    public Name getNameProduct() {
        return nameProduct;
    }

    public ValueProduct getValueProduct() {
        return valueProduct;
    }
}
