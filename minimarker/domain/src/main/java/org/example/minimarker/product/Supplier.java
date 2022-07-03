package org.example.minimarker.product;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.SupplierId;

import java.util.Objects;

public class Supplier extends Entity<SupplierId> {

    private Name name;

    public Supplier(SupplierId entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public void updateName(Name name){
        this.name = name;
    }

    public Name name() {
        return name;
    }
}
