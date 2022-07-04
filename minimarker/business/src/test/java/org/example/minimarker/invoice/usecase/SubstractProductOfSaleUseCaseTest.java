package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.commands.SubstractProductOfSaleCommand;
import org.example.minimarker.invoice.events.InvoiceCreated;
import org.example.minimarker.invoice.events.ProductOfSaleSubstracted;
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
class SubstractProductOfSaleUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    SubstractProductOfSaleUseCase useCase;

    @Test
    public void whenProductIsSubstractOfSale() throws IllegalAccessException {
        InvoiceId invoiceId = InvoiceId.of("invoiceId");
        SaleId saleId = SaleId.of("saleId");
        ProductId productId = ProductId.of("product1");

        var command = new SubstractProductOfSaleCommand(invoiceId, saleId, productId);
        when(repository.getEventsBy(invoiceId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ProductOfSaleSubstracted)events.get(0);
        Assertions.assertEquals("product1", event.productId().value());
    }

    private List<DomainEvent> history() throws IllegalAccessException {
        SaleId saleId = SaleId.of("saleId");
        AssessorId assessorId = AssessorId.of("assesorId");
        NameAssessor name = new NameAssessor("Doe");
        ClientId clientId = ClientId.of("cccc");

        ProductId productId = ProductId.of("product1");
        ValueProduct valueProduct = new ValueProduct(2000.0);

        return List.of(
                new InvoiceCreated(saleId, assessorId, name, clientId),
                new ProductToSaleAdded(saleId, productId, valueProduct)
        );
    }

}