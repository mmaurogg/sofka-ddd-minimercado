package org.example.minimarker.invoice;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.invoice.values.*;
import org.example.minimarker.product.Product;
import org.example.minimarker.product.values.ProductId;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Sale extends Entity<SaleId> {

    private Value value;
    private Set<Product> products;

    public Sale(SaleId entityId) {
        super(entityId);
        this.products = new HashSet<>();
        this.value = new Value(0.0);
    }

    public Optional<Product> getProductById(ProductId productId){
        return products()
                .stream()
                .filter(product -> product.identity().equals(productId))
                .findFirst();
    }

    public void addProduct(Product product){
        Objects.requireNonNull(product);
        this.products.add(product);
    }

    public void substractProduct(ProductId productId){
        Product product = getProductById(productId)
                .orElseThrow(() -> new IllegalArgumentException("No se encuentra el producto"));
        products().remove(product);
    }

    public void calculateValue (){
        var sumValue = this.products
                .stream()
                .map(product -> product.valueProduct().value())
                .mapToDouble(value -> value).sum();
        this.value = new Value(sumValue);
    }

    public Value value() {
        return value;
    }

    public Set<Product> products() {
        return products;
    }
}
