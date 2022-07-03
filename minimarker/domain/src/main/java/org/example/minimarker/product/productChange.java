package org.example.minimarker.product;

import co.com.sofka.domain.generic.EventChange;
import org.example.minimarker.product.events.*;

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

        apply((SKUAdded event)->{
            product.sku = new SKU(event.skuId(), event.place(), event.stock());
        });

        apply((NameOfSupplierUpdated event)->{
            if(!product.supplier.identity().equals(event.supplierId())){
                try {
                    throw new IllegalAccessException("No se encuentra el proveedor ese id");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            product.supplier.updateName(event.nameSupplier());
        });

        apply((StockOfSKUUpdated event)->{
            if(!product.sku.identity().equals(event.skuId())){
                try {
                    throw new IllegalAccessException("No se encuentra el proveedor ese id");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            product.sku.updateStock(event.stock());
        });

        apply((TypeOfCategoryUpdated event)->{
            if(!product.category.identity().equals(event.categoryId())){
                try {
                    throw new IllegalAccessException("No se encuentra el proveedor ese id");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            product.category.updateTypeProduct(event.typeProduct());
        });
    }
}
