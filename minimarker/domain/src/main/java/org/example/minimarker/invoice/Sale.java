package org.example.minimarker.invoice;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.invoice.values.*;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.ValueProduct;

import java.util.*;

public class Sale extends Entity<SaleId> {

    private Value value;
    private Map<ProductId, ValueProduct> products;

    public Sale(SaleId entityId) {
        super(entityId);
        this.products = new HashMap<>();
        this.value = new Value(0.0);
    }

    public void addProduct(ProductId productId, ValueProduct valueProduct){
        Objects.requireNonNull(productId);
        Objects.requireNonNull(valueProduct);
        this.products.put(productId, valueProduct);
    }

    public void substractProduct(ProductId productId){
        var product = products.get(productId);
        if (product == null){
            throw new IllegalArgumentException("No se encuentra ese producto en la lista");
        }
        products.remove(product);

    }

    public void calculateValue (){
        Double sumValue = products.values()
                .stream()
                .map(valueProduct -> valueProduct.value())
                .mapToDouble(Double::doubleValue)
                .sum();
        this.value = new Value(sumValue);
    }

    public Value value() {
        return value;
    }

    public Map<ProductId, ValueProduct> products() {
        return products;
    }
}
