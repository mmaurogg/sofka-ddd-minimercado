package org.example.minimarker.invoice;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.events.*;
import org.example.minimarker.invoice.values.*;
import org.example.minimarker.product.Product;

import java.util.List;
import java.util.Objects;

public class Invoice extends AggregateEvent<InvoiceId> {

    protected Date date;
    protected Assessor assessor;
    protected Payment payment;
    protected Sale sale;
    protected ClientId clientId;

    private Invoice(InvoiceId invoiceId){
        super(invoiceId);
        subscribe(new InvoiceChange(this));
    }

    public static Invoice from (InvoiceId invoiceId, List<DomainEvent> events){
        var invoice = new Invoice(invoiceId);
        events.forEach(invoice::applyEvent);
        return invoice;
    }
    public Invoice(InvoiceId invoiceId, SaleId saleId, AssessorId assessorId, NameAssessor name, ClientId clientId) {
        super(invoiceId);
        appendChange(new InvoiceCreated(saleId, assessorId, name, clientId)).apply();
        subscribe(new InvoiceChange(this));
    }

    public void calculateValueSale(SaleId saleId){
        appendChange(new ValueSaleCalculated(saleId)).apply();
    }

    public void addProductToSale(SaleId saleId, Product product){
        Objects.requireNonNull(product);
        appendChange(new ProductToSaleAdded(saleId, product)).apply();
    }
    public void substractProductOfSale(SaleId saleId, Product product){
        Objects.requireNonNull(product);
        appendChange(new ProductOfSaleSubstracted(saleId, product)).apply();
    }
    public void updateAssesorName(AssessorId assessorId, NameAssessor name){
        Objects.requireNonNull(name);
        appendChange(new AssesorNameUpdated(assessorId, name)).apply();
    }

    public void updatePaymentValue(PaymentId paymentId, Value value){
        Objects.requireNonNull(value);
        appendChange(new PaymentValueUpdated(paymentId, value)).apply();
    }

    public void updatePaymentMethod(PaymentId paymentId, Method method){
        Objects.requireNonNull(method);
        appendChange(new PaymentMethodUpdated(paymentId, method)).apply();
    }

}
