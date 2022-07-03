package org.example.minimarker.product.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.Category;
import org.example.minimarker.product.values.CategoryId;
import org.example.minimarker.product.values.TypeProduct;

public class CategoryAdded extends DomainEvent {
    private final CategoryId categoryId;
    private final TypeProduct typeProduct;

    public CategoryAdded(CategoryId categoryId, TypeProduct typeProduct) {
        super("org.example.minimarker.product.categoryadded");
        this.categoryId = categoryId;
        this.typeProduct = typeProduct;
    }

    public TypeProduct typeProduct() {
        return typeProduct;
    }
    public CategoryId categoryId() {
        return categoryId;
    }
}
