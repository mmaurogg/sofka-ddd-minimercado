package org.example.minimarker.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.invoice.values.Method;
import org.example.minimarker.invoice.values.PaymentId;

public class PaymentMethodUpdated extends DomainEvent {
    private final PaymentId paymentId;
    private final Method method;

    public PaymentMethodUpdated(PaymentId paymentId, Method method) {
        super("sofka.invoice.paymentmethodupdated");
        this.paymentId = paymentId;
        this.method = method;
    }

    public PaymentId paymentId() {
        return paymentId;
    }

    public Method method() {
        return method;
    }
}
