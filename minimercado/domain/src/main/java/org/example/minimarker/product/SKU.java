package org.example.minimarker.product;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.product.values.Place;
import org.example.minimarker.product.values.SKUId;
import org.example.minimarker.product.values.Stock;

import java.util.Objects;

public class SKU extends Entity<SKUId> {

    private Place place;
    private Stock stock;

    public SKU(SKUId entityId, Place place, Stock stock) {
        super(entityId);
        this.place = place;
        this.stock = stock;
    }

    public void updateStock(Stock stock){
        this.stock = Objects.requireNonNull(stock);
    }

    public Place place() {
        return place;
    }

    public Stock stock() {
        return stock;
    }
}
