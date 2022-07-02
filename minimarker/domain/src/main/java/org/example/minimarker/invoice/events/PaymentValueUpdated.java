package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.invoice.values.PaymentId;
import org.example.minimarker.invoice.values.Value;

public class PaymentValueUpdated extends DomainEvent {
    private final PaymentId paymentId;
    private final Value value;

    public PaymentValueUpdated(PaymentId paymentId, Value value) {
        super("sofka.invoice.paymentvalueupdated");
        this.paymentId = paymentId;
        this.value = value;
    }

    public PaymentId paymentId() {
        return paymentId;
    }

    public Value value() {
        return value;
    }
}
