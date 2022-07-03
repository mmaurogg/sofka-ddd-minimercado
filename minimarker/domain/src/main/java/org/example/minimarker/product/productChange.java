package org.example.minimarker.product;

import co.com.sofka.domain.generic.EventChange;
import org.example.minimarker.product.events.*;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.SupplierId;
import org.example.minimarker.product.values.ValueProduct;

public class productChange extends EventChange {
    public productChange(Product product) {

        apply((ProductCreated event)->{
            product.supplier = new Supplier(event.getSupplierId(), event.getNameSupplier());
            product.nameProduct = event.getNameProduct();
            product.valueProduct = event.getValueProduct();
            product.category = null;
            product.sku = null;
        });

        apply((CategoryAdded event)->{
            product.category = new Category(event.categoryId(), event.typeProduct());
        });

        apply((NameOfSupplierUpdated event)->{
            product.supplier.updateName(event.nameSupplier());
        });

        apply((SKUAdded event)->{
            product.sku = new SKU(event.skuId(), event.place(), event.stock());
        });

        apply((StockOfSKUUpdated event)->{
            product.updateStockOfSKU(event.skuId(), event.stock());
        });

        apply((TypeOfCategoryUpdated event)->{
            product.updateTypeOfCategory(event.categoryId(), event.typeProduct());
        });
    }
}
