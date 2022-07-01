package org.example.minimarker.product;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.product.values.CategoryId;
import org.example.minimarker.product.values.TypeProduct;

import java.util.Objects;

public class Category extends Entity<CategoryId> {

    private TypeProduct typeProduct;

    public Category(CategoryId entityId, TypeProduct typeProduct) {
        super(entityId);
        this.typeProduct = typeProduct;
    }

    public void updateTypeProduct(TypeProduct typeProduct){
        this.typeProduct = Objects.requireNonNull(typeProduct);
    }

    public TypeProduct typeProduct() {
        return typeProduct;
    }
}
