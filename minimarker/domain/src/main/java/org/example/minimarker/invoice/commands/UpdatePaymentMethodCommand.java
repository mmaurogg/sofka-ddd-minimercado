package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.Method;
import org.example.minimarker.invoice.values.PaymentId;

public class UpdatePaymentMethodCommand extends Command {

    private final InvoiceId invoiceId;
    private final PaymentId paymentId;
    private final Method method;

    public UpdatePaymentMethodCommand(InvoiceId invoiceId, PaymentId paymentId, Method method) {
        this.invoiceId = invoiceId;
        this.paymentId = paymentId;
        this.method = method;
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
}
