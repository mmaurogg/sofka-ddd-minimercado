package org.example.minimarker.product.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.SKU;
import org.example.minimarker.product.values.Place;
import org.example.minimarker.product.values.SKUId;
import org.example.minimarker.product.values.Stock;

public class SKUAdded extends DomainEvent {

    private final SKUId skuId;
    private final Place place;
    private final Stock stock;

    public SKUAdded(SKUId skuId, Place place, Stock stock) {
        super("sofka.product.skuadded");

        this.skuId = skuId;
        this.place = place;
        this.stock = stock;
    }

    public SKUId skuId() {
        return skuId;
    }

    public Place place() {
        return place;
    }

    public Stock stock() {
        return stock;
    }
}
