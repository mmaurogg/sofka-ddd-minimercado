package org.example.minimarker.product;

import co.com.sofka.domain.generic.EventChange;
import org.example.minimarker.product.events.*;

public class productChange extends EventChange {
    public productChange(Product product) {

        apply((CategoryAdded event)->{
            product.category = new Category(event.categoryId(), event.typeProduct());
        });

        apply((NameOfSupplierUpdated event)->{
            product.updateNameOfSupplier(event.supplierId(), event.name());
        });

        apply((ProductCreated event)->{
            product.name = event.name();
            product.valueProduct = event.valueProduct();
        });

        apply((SKUAdded event)->{
            product.sku = new SKU(event.skuId(), event.place(), event.stock());
        });

        apply((StockOfSKUUpdated event)->{
            product.updateStockOfSKU(event.skuId(), event.stock());
        });

        apply((SupplierAdded event)->{
            product.supplier = new Supplier(event.supplierId(), event.name());
        });

        apply((TypeOfCategoryUpdated event)->{
            product.updateTypeOfCategory(event.categoryId(), event.typeProduct());
        });
    }
}
