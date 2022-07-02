package org.example.minimarker.product;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.events.*;
import org.example.minimarker.product.values.*;

import java.util.List;
import java.util.Objects;

public class Product extends AggregateEvent<ProductId> {

    protected Name name;
    protected Supplier supplier;
    protected ValueProduct valueProduct;
    protected Category category;
    protected SKU sku;

    private Product(ProductId productId){
        super(productId);
        subscribe(new productChange(this));
    }

    public static Product from (ProductId productId, List<DomainEvent> events){
        var product = new Product(productId);
        events.forEach(product::applyEvent);
        return product;
    }

    public Product(ProductId productId, Name name, ValueProduct valueProduct) {
        super(productId);
        this.name = name;
        this.valueProduct = valueProduct;
        subscribe(new productChange(this));
        appendChange(new  ProductCreated(productId, name, valueProduct));
    }

    public void updateNameOfSupplier(SupplierId supplierId, Name name){
        Objects.requireNonNull(name);
        appendChange(new NameOfSupplierUpdated(supplierId, name)).apply();
    }

    public void updateTypeOfCategory(CategoryId categoryId, TypeProduct typeProduct){
        Objects.requireNonNull(typeProduct);
        appendChange(new TypeOfCategoryUpdated(categoryId, typeProduct)).apply();
    }

    public void updateStockOfSKU( SKUId skuId, Stock stock){
        Objects.requireNonNull(stock);
        appendChange(new StockOfSKUUpdated(skuId, stock)).apply();
    }

    public Name name() {
        return name;
    }

    public Supplier supplier() {
        return supplier;
    }

    public ValueProduct valueProduct() {
        return valueProduct;
    }

    public Category category() {
        return category;
    }

    public SKU sku() {
        return sku;
    }
}
