package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.invoice.values.SaleId;

public class ValueSaleCalculated extends DomainEvent {
    private final SaleId saleId;

    public ValueSaleCalculated(SaleId saleId) {
        super("sofka.invoice.valuesalecalculated");
        this.saleId = saleId;
    }

    public SaleId saleId() {
        return saleId;
    }
}
