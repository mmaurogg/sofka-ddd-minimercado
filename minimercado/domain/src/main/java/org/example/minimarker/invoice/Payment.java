package org.example.minimarker.invoice;

import co.com.sofka.domain.generic.Entity;
import org.example.minimarker.invoice.values.Date;
import org.example.minimarker.invoice.values.Method;
import org.example.minimarker.invoice.values.PaymentId;
import org.example.minimarker.invoice.values.Value;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.LocalDate.now;

public class Payment extends Entity <PaymentId> {

    private Date date;
    private Method method;
    private Value value;

    public Payment(PaymentId entityId, Method method, Value value) {
        super(entityId);
        this.method = Objects.requireNonNull(method);
        this.value = Objects.requireNonNull(value);
        this.date = new Date(now().getDayOfMonth(),now().getMonthValue(), now().getYear());
    }

    public void updateValue(Value value){
        this.value = Objects.requireNonNull(value);
    }

    public void updateMethod(Method method) {
        this.method = Objects.requireNonNull(method);
    }

    public Date date() {
        return date;
    }

    public Method method() {
        return method;
    }

    public Value value() {
        return value;
    }
}
