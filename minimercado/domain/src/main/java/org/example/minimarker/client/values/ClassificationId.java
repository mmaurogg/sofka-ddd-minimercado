package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.Identity;

public class ClassificationId extends Identity {

    public ClassificationId(String id){
        super(id);
    }

    public ClassificationId(){}

    public static ClassificationId of(String id){
        return new ClassificationId(id);
    }
}
