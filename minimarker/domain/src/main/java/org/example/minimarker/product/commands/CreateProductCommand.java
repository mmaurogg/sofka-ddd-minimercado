package org.example.minimarker.product.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.ValueProduct;

public class CreateProductCommand extends Command {

    private final ProductId productId;
    private final Name nameSupplier;
    private final Name nameProduct;
    private final ValueProduct valueProduct;

    public CreateProductCommand(ProductId productId, Name nameSupplier, Name nameProduct, ValueProduct valueProduct){
        this.productId = productId;
        this.nameSupplier = nameSupplier;
        this.nameProduct = nameProduct;
        this.valueProduct = valueProduct;
    }

    public ProductId getProductId() {
        return productId;
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
