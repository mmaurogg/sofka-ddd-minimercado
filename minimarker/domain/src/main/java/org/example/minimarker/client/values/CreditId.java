package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.Identity;

public class CreditId extends Identity {

    public CreditId(String id){
        super(id);
    }

    public CreditId(){}

    public static CreditId of(String id){
        return new CreditId(id);
    }
}
