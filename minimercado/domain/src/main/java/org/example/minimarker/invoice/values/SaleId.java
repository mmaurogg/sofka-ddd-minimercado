package org.example.minimarker.invoice.values;

import co.com.sofka.domain.generic.Identity;

public class SaleId extends Identity {

    public SaleId(String id){
        super(id);
    }

    public SaleId(){}

    public static SaleId of(String id){
        return new SaleId(id);
    }
}
