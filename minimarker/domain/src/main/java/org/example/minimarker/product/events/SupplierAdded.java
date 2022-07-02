package org.example.minimarker.product.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.SupplierId;

public class SupplierAdded extends DomainEvent {
    private final SupplierId supplierId;
    private final Name name;

    public SupplierAdded(SupplierId supplierId, Name name) {
        super("sofka.product.supplieradded");
        this.supplierId = supplierId;
        this.name = name;
    }

    public Name name() {
        return name;
    }

    public SupplierId supplierId() {
        return supplierId;
    }
}
