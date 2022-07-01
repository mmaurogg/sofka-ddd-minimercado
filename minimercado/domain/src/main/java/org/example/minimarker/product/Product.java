package org.example.minimarker.product;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.minimarker.product.values.*;

import java.util.Objects;

public class Product extends AggregateEvent<ProductId> {

    protected Name name;
    protected Supplier supplier;
    protected ValueProduct valueProduct;
    protected Category category;
    protected SKU sku;

    public Product(ProductId entityId, Name name, ValueProduct valueProduct) {
        super(entityId);
        this.name = name;
        this.valueProduct = valueProduct;
    }

    public void addSupplier(SupplierId supplierId, Name name){
        Objects.requireNonNull(name);
        appendChange(new SupplierAdded(supplierId, name)).apply();
    }

    public void addCategory(CategoryId categoryId, Category category){
        Objects.requireNonNull(category);
        appendChange(new SupplierAdded(categoryId, category)).apply();
    }

    public void addSKU(SKUId skuId, SKU sku){
        Objects.requireNonNull(sku);
        appendChange(new SupplierAdded(skuId, sku)).apply();
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
