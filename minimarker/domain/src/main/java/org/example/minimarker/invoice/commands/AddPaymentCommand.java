package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.Method;
import org.example.minimarker.invoice.values.PaymentId;
import org.example.minimarker.invoice.values.Value;

public class AddPaymentCommand extends Command {

    private final InvoiceId invoiceId;
    private final PaymentId paymentId;
    private final Method method;
    private final Value value;

    public AddPaymentCommand(InvoiceId invoiceId, PaymentId paymentId, Method method, Value value) {
        this.invoiceId = invoiceId;
        this.paymentId = paymentId;
        this.method = method;
        this.value = value;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public PaymentId getPaymentId() {
        return paymentId;
    }

    public Method getMethod() {
        return method;
    }

    public Value getValue() {
        return value;
    }
}
