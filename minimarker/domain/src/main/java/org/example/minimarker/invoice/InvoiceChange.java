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

        apply((PaymentAdded event) -> {
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
            invoice.payment.updateMethod(event.method());
        });

        apply((PaymentValueUpdated event)->{
            if(!invoice.payment.identity().equals(event.paymentId())) {
                try {
                    throw new IllegalAccessException("Aun no hay pago para esta factura");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            invoice.payment.updateValue(event.value());
        });

        apply((AssesorNameUpdated event)->{
            invoice.assessor.updateName(event.name());
        });

        apply((ProductToSaleAdded event)->{
            invoice.sale.addProduct(event.productId(), event.getValueProduct());
        });

        apply((ProductOfSaleSubstracted event)->{
            invoice.sale.substractProduct( event.productId());
        });

        apply((ValueSaleCalculated event)->{
            invoice.sale.calculateValue();
        });

    }
}
