package org.example.minimarker.product.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.product.values.CategoryId;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.TypeProduct;

public class UpdateTypeOfCategoryCommand extends Command {

    private final ProductId productId;
    private final CategoryId categoryId;
    private final TypeProduct typeProduct;

    public UpdateTypeOfCategoryCommand(ProductId productId, CategoryId categoryId, TypeProduct typeProduct) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.typeProduct = typeProduct;
    }

    public ProductId getProductId() {
        return productId;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }
}
