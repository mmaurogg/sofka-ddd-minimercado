package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.commands.UpdateNameOfSupplierCommand;
import org.example.minimarker.product.events.NameOfSupplierUpdated;
import org.example.minimarker.product.events.ProductCreated;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.SupplierId;
import org.example.minimarker.product.values.ValueProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateNameOfSupplierUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    UpdateNameOfSupplierUseCase useCase;

    @Test
    public void whenNameOfSupplierIsUpdated() throws IllegalAccessException {

        ProductId productId = ProductId.of("pppp");
        SupplierId supplierId = SupplierId.of("ssss");
        Name newName = new Name("NewSupplierName");
        var command = new UpdateNameOfSupplierCommand(productId, supplierId, newName);
        when(repository.getEventsBy(productId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NameOfSupplierUpdated)events.get(0);
        Assertions.assertEquals("NewSupplierName", command.getNameSupplier());

    }

    private List<DomainEvent> history() throws IllegalAccessException {

        SupplierId supplierId = new SupplierId("ssss");
        Name nameSupplier = new Name("supllierName");
        Name nameProduct = new Name("productName");
        ValueProduct valueProduct = new ValueProduct(200.0);
        return List.of(
                new ProductCreated(supplierId, nameSupplier, nameProduct, valueProduct)
        );
    }
}