package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.invoice.values.Method;
import org.example.minimarker.invoice.values.PaymentId;
import org.example.minimarker.invoice.values.Value;

public class PaymentAdded extends DomainEvent {
    private final PaymentId paymentId;
    private final Method method;
    private final Value value;

    public PaymentAdded(PaymentId paymentId, Method method, Value value) {
        super("sofka.invoice.paymentadded");
        this.paymentId = paymentId;
        this.method = method;
        this.value = value;
    }

    public PaymentId paymentId() {
        return paymentId;
    }

    public Method method() {
        return method;
    }

    public Value value() {
        return value;
    }
}
