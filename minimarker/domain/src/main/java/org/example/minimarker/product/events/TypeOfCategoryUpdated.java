package org.example.minimarker.product.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.values.CategoryId;
import org.example.minimarker.product.values.TypeProduct;

public class TypeOfCategoryUpdated extends DomainEvent {
    private final CategoryId categoryId;
    private final TypeProduct typeProduct;

    public TypeOfCategoryUpdated(CategoryId categoryId, TypeProduct typeProduct) {
        super("sofka.product.typeofcategoryupdated");
        this.categoryId = categoryId;
        this.typeProduct = typeProduct;
    }

    public CategoryId categoryId() {
        return categoryId;
    }

    public TypeProduct typeProduct() {
        return typeProduct;
    }
}
