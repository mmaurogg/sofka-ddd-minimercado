package org.example.minimarker.invoice.values;

import co.com.sofka.domain.generic.Identity;

public class PaymentId extends Identity {

    public PaymentId(String id){
        super(id);
    }

    public PaymentId(){}

    public static PaymentId of(String id){
        return new PaymentId(id);
    }
}
