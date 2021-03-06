package org.example.minimarker.product;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.events.*;
import org.example.minimarker.product.values.*;

import java.util.List;
import java.util.Objects;

public class Product extends AggregateEvent<ProductId> {

    protected Supplier supplier;
    protected Name nameProduct;
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

    public Product(ProductId productId, SupplierId supplierId, Name nameSupplier, Name nameProduct, ValueProduct valueProduct) {
        super(productId);
        appendChange(new ProductCreated(supplierId, nameSupplier, nameProduct, valueProduct)).apply();
        subscribe(new productChange(this));
    }

    public void AddCategory(CategoryId categoryId, TypeProduct typeProduct){
        Objects.requireNonNull(typeProduct);
        appendChange(new CategoryAdded(categoryId, typeProduct)).apply();
    }

    public void AddSKU(SKUId skuId, Place place, Stock stock){
        Objects.requireNonNull(place);
        Objects.requireNonNull(stock);
        appendChange(new SKUAdded(skuId, place, stock)).apply();
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

}
