package org.example.minimarker.product.values;

import co.com.sofka.domain.generic.Identity;

public class SKUId extends Identity {

    public SKUId(String id){
        super(id);
    }

    public SKUId(){}

    public static SKUId of(String id){
        return new SKUId(id);
    }
}
