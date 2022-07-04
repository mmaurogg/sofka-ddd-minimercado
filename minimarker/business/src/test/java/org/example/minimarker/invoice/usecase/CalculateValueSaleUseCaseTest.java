package org.example.minimarker.invoice.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.example.minimarker.client.values.ClientId;
import org.example.minimarker.invoice.commands.CalculateValueSaleCommand;
import org.example.minimarker.invoice.events.InvoiceCreated;
import org.example.minimarker.invoice.events.ProductToSaleAdded;
import org.example.minimarker.invoice.events.ValueSaleCalculated;
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
class CalculateValueSaleUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CalculateValueSaleUseCase useCase;

    @Test
    public void whenIsCalculatedTheValueOfSale() throws IllegalAccessException {
        InvoiceId invoiceId = InvoiceId.of("invoiceId");
        SaleId saleId = SaleId.of("saleId");

        var command = new CalculateValueSaleCommand(invoiceId, saleId);
        when(repository.getEventsBy(invoiceId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ValueSaleCalculated)events.get(0);
        Assertions.assertEquals("saleId", event.saleId().value());
    }

    private List<DomainEvent> history() throws IllegalAccessException {
        SaleId saleId = SaleId.of("saleId");
        AssessorId assessorId = AssessorId.of("assesorId");
        NameAssessor name = new NameAssessor("Doe");
        ClientId clientId = ClientId.of("cccc");

        ProductId productId = ProductId.of("product1");
        ValueProduct valueProduct = new ValueProduct(2000.0);

        ProductId productId2 = ProductId.of("product2");
        ValueProduct valueProduct2 = new ValueProduct(1000.0);

        return List.of(
                new InvoiceCreated(saleId, assessorId, name, clientId),
                new ProductToSaleAdded(saleId, productId, valueProduct),
                new ProductToSaleAdded(saleId, productId2, valueProduct2)
        );
    }

}