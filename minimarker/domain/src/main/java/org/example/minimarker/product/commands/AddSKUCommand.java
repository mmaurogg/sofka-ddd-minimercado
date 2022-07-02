package org.example.minimarker.product.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.product.values.Place;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.SKUId;
import org.example.minimarker.product.values.Stock;

public class AddSKUCommand extends Command {

    private final ProductId productId;
    private final SKUId skuId;
    private final Place place;
    private final Stock stock;

    public AddSKUCommand(ProductId productId, SKUId skuId, Place place, Stock stock) {
        this.productId = productId;
        this.skuId = skuId;
        this.place = place;
        this.stock = stock;
    }

    public ProductId getProductId() {
        return productId;
    }

    public SKUId getSkuId() {
        return skuId;
    }

    public Place getPlace() {
        return place;
    }

    public Stock getStock() {
        return stock;
    }
}
