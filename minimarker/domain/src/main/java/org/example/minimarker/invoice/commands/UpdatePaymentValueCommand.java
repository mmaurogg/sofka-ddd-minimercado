package org.example.minimarker.invoice.commands;

import co.com.sofka.domain.generic.Command;
import org.example.minimarker.invoice.values.InvoiceId;
import org.example.minimarker.invoice.values.PaymentId;
import org.example.minimarker.invoice.values.Value;

public class UpdatePaymentValueCommand extends Command {

    private final InvoiceId invoiceId;
    private final PaymentId paymentId;
    private final Value value;

    public UpdatePaymentValueCommand(InvoiceId invoiceId, PaymentId paymentId, Value value) {
        this.invoiceId = invoiceId;
        this.paymentId = paymentId;
        this.value = value;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public PaymentId getPaymentId() {
        return paymentId;
    }

    public Value getValue() {
        return value;
    }
}
