package org.example.minimarker.product.values;

import co.com.sofka.domain.generic.Identity;

public class CategoryId extends Identity {

    public CategoryId(String id){
        super(id);
    }

    public CategoryId(){}

    public static CategoryId of(String id){
        return new CategoryId(id);
    }
}
