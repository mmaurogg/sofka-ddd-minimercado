package org.example.minimarker.invoice;

import co.com.sofka.domain.generic.EventChange;
import org.example.minimarker.invoice.events.*;
import org.example.minimarker.invoice.values.Date;

import static java.time.LocalDate.now;

public class InvoiceChange  extends EventChange {
    public InvoiceChange(Invoice invoice)  {

        apply((InvoiceCreated event)->{
            invoice.date = new Date(now().getDayOfMonth(),now().getMonthValue(), now().getYear());
            invoice.payment = null;
            invoice.sale = new Sale(event.saleId());
            invoice.assessor = new Assessor(event.assessorId(), event.name());
            invoice.clientId = event.clientId();
        });

        apply((AssesorNameUpdated event)->{
            invoice.updateAssesorName(event.assessorId(), event.name());
        });

        apply((PaymentAdded event)->{
            invoice.payment = new Payment(event.paymentId(), event.method(), event.value());
        });

        apply((PaymentMethodUpdated event)->{
            if(!invoice.payment.identity().equals(event.paymentId())) {
                try {
                    throw new IllegalAccessException("Aun no hay pago para esta factura");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            invoice.updatePaymentMethod(event.paymentId(), event.method());
        });

        apply((PaymentValueUpdated event)->{
            if(!invoice.payment.identity().equals(event.paymentId())) {
                try {
                    throw new IllegalAccessException("Aun no hay pago para esta factura");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            invoice.updatePaymentValue(event.paymentId(), event.value());
        });

        apply((ProductToSaleAdded event)->{
            invoice.addProductToSale(event.saleId(), event.product());
        });

        apply((ProductOfSaleSubstracted event)->{
            invoice.substractProductOfSale(event.saleId(), event.product());
        });

        apply((ValueSaleCalculated event)->{
            invoice.calculateValueSale(event.saleId());
        });

    }
}
