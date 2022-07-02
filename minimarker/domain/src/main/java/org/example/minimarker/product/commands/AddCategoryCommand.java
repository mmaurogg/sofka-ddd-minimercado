package org.example.minimarker.product.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.product.values.CategoryId;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.TypeProduct;

public class AddCategoryCommand extends Command {

    private final ProductId productId;
    private final CategoryId entityId;
    private final TypeProduct typeProduct;

    public AddCategoryCommand(ProductId productId, CategoryId entityId, TypeProduct typeProduct) {
        this.productId = productId;
        this.entityId = entityId;
        this.typeProduct = typeProduct;
    }

    public ProductId getProductId() {
        return productId;
    }

    public CategoryId getEntityId() {
        return entityId;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }
}
