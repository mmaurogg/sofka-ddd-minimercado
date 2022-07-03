package org.example.minimarker.product.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.values.SKUId;
import org.example.minimarker.product.values.Stock;

public class StockOfSKUUpdated extends DomainEvent {
    private final SKUId skuId;
    private final Stock stock;

    public StockOfSKUUpdated(SKUId skuId, Stock stock) {
        super("org.example.minimarker.product.stockofskuupdated");
        this.skuId = skuId;
        this.stock = stock;
    }

    public Stock stock() {
        return stock;
    }

    public SKUId skuId() {
        return skuId;
    }
}
