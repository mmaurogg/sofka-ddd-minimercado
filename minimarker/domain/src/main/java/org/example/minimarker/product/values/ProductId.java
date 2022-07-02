package org.example.minimarker.product.values;

import co.com.sofka.domain.generic.Identity;

public class ProductId extends Identity {

    public ProductId(String id){
        super(id);
    }

    public ProductId(){}

    public static ProductId of(String id){
        return new ProductId(id);
    }
}
