package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.Identity;

public class ClientId extends Identity {

    public ClientId(String id){
        super(id);
    }

    public ClientId(){}

    public static ClientId of(String id){
        return new ClientId(id);
    }
}
