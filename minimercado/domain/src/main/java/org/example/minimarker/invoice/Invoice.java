package org.example.minimarker.invoice;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.values.*;
import org.example.minimarker.product.Product;

import java.util.Objects;

import static java.time.LocalDate.now;

public class Invoice extends AggregateEvent<InvoiceId> {

    protected Date date;
    protected Assessor assessor;
    protected Payment payment;
    protected Sale sale;
    protected ClientId clientId;

    public Invoice(InvoiceId entityId, Assessor assessor, ClientId clientId) {
        super(entityId);
        this.assessor = assessor;
        this.clientId = clientId;
        this.date = new Date(now().getDayOfMonth(),now().getMonthValue(), now().getYear());
        this.sale = new Sale(new SaleId());
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

    public void addPayment(PaymentId paymentId, Method method, Value value){
        Objects.requireNonNull(method);
        Objects.requireNonNull(value);
        appendChange(new PaymentAdded(paymentId, method, value)).apply();
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
