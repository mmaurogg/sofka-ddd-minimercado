package org.example.minimarker.product.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.SupplierId;

public class UpdateNameOfSupplierCommand extends Command {

    private final ProductId productId;
    private final SupplierId supplierId;
    private final Name name;

    public UpdateNameOfSupplierCommand(ProductId productId, SupplierId supplierId, Name name) {
        this.productId = productId;
        this.supplierId = supplierId;
        this.name = name;
    }

    public ProductId getProductId() {
        return productId;
    }

    public SupplierId getSupplierId() {
        return supplierId;
    }

    public Name getName() {
        return name;
    }
}
