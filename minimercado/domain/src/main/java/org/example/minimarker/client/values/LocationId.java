package org.example.minimarker.client.values;

import co.com.sofka.domain.generic.Identity;

public class LocationId extends Identity {

    public LocationId(String id){
        super(id);
    }

    public LocationId(){}

    public static LocationId of(String id){
        return new LocationId(id);
    }
}
