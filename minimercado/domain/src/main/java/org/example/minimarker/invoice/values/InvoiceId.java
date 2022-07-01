package org.example.minimarker.invoice.values;

import co.com.sofka.domain.generic.Identity;

public class InvoiceId extends Identity {

    public InvoiceId(String id){
        super(id);
    }

    public InvoiceId(){}

    public static InvoiceId of(String id){
        return new InvoiceId(id);
    }
}
