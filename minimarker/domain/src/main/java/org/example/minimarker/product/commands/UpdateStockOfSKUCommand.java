package org.example.minimarker.product.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.SKUId;
import org.example.minimarker.product.values.Stock;

public class UpdateStockOfSKUCommand extends Command {

    private final ProductId productId;
    private final SKUId skuId;
    private final Stock stock;

    public UpdateStockOfSKUCommand(ProductId productId, SKUId skuId, Stock stock) {
        this.productId = productId;
        this.skuId = skuId;
        this.stock = stock;
    }

    public ProductId getProductId() {
        return productId;
    }

    public SKUId getSkuId() {
        return skuId;
    }

    public Stock getStock() {
        return stock;
    }
}
