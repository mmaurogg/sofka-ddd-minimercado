package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.commands.AddProductToSaleCommand;
import org.example.minimarker.invoice.events.InvoiceCreated;
import org.example.minimarker.invoice.events.ProductToSaleAdded;
import org.example.minimarker.invoice.values.*;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.ValueProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AddProductUseCase useCase;

    @Test
    public void whenProductIsAddToSale() throws IllegalAccessException {
        InvoiceId invoiceId = InvoiceId.of("invoiceId");
        SaleId saleId = SaleId.of("saleId");
        ProductId productId = ProductId.of("product1");
        ValueProduct valueProduct = new ValueProduct(2000.0);

        var command = new AddProductToSaleCommand(invoiceId, saleId, productId, valueProduct);
        when(repository.getEventsBy(invoiceId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ProductToSaleAdded)events.get(0);
        Assertions.assertEquals("product1", event.productId().value());
        Assertions.assertEquals(2000.0, event.getValueProduct().value());
    }

    private List<DomainEvent> history() {
        SaleId saleId = SaleId.of("saleId");
        AssessorId assessorId = AssessorId.of("assesorId");
        NameAssessor name = new NameAssessor("Doe");
        ClientId clientId = ClientId.of("cccc");

        PaymentId paymentId = PaymentId.of("paymentId");
        Method method = new Method("method of payment");
        Value value = new Value(134.0);

        return List.of(
                new InvoiceCreated(saleId, assessorId, name, clientId)
        );
    }

}