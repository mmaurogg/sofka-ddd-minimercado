package org.example.minimarker.product.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.ValueProduct;

public class CreateProductCommand extends Command {

    private final ProductId productId;
    private final Name name;
    private final ValueProduct valueProduct;

    public CreateProductCommand(ProductId productId, Name name, ValueProduct valueProduct) {
        this.productId = productId;
        this.name = name;
        this.valueProduct = valueProduct;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Name getName() {
        return name;
    }

    public ValueProduct getValueProduct() {
        return valueProduct;
    }
}
