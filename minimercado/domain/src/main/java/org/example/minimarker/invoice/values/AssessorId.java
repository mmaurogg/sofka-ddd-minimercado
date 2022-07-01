package org.example.minimarker.invoice.values;

import co.com.sofka.domain.generic.Identity;
import org.example.minimarker.client.values.CreditId;

public class AssessorId extends Identity {

    public AssessorId(String id){
        super(id);
    }

    public AssessorId(){}

    public static AssessorId of(String id){
        return new AssessorId(id);
    }
}
