package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.example.minimarker.product.events.ProductCreated;
import org.example.minimarker.product.values.Name;
import org.example.minimarker.product.values.ProductId;
import org.example.minimarker.product.values.ValueProduct;
import org.example.minimarker.product.commands.CreateProductCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {

    @InjectMocks
    CreateProductUseCase useCase;

    @Test
    public void whenAProductIsCreated() throws IllegalAccessException {
        ProductId productId = ProductId.of("pppp");
        Name nameSupplier = new Name("SuplierName");
        Name nameProduct = new Name("ProductName");
        ValueProduct valueProduct = new ValueProduct(100.0);

        var command = new CreateProductCommand( productId, nameSupplier, nameProduct, valueProduct);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ProductCreated)events.get(0);
        Assertions.assertEquals("SuplierName", event.getNameSupplier().value());
        Assertions.assertEquals("ProductName", event.getNameProduct().value());
        Assertions.assertEquals(100.00, event.getValueProduct().value());
    }

}