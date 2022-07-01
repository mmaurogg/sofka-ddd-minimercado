package org.example.minimarker.product.values;

import co.com.sofka.domain.generic.Identity;

public class SupplierId extends Identity {

    public SupplierId(String id){
        super(id);
    }

    public SupplierId(){}

    public static SupplierId of(String id){
        return new SupplierId(id);
    }
}
