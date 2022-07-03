package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.commands.AddCategoryCommand;
import org.example.minimarker.product.events.CategoryAdded;
import org.example.minimarker.product.events.ProductCreated;
import org.example.minimarker.product.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddCategoryUseCaseTest {

    @InjectMocks
     AddCategoryUseCase useCase;

    @Mock
    DomainEventRepository repository;

    @Test
    public void whenCategoryIsAdded() throws IllegalAccessException {
        ProductId productId = ProductId.of("pppp");
        CategoryId categoryId = CategoryId.of("cccc");
        TypeProduct typeProduct = new TypeProduct("Hogar");

        var command = new AddCategoryCommand(productId, categoryId, typeProduct);
        when(repository.getEventsBy(productId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CategoryAdded)events.get(0);
        Assertions.assertEquals("Hogar", event.typeProduct().value());
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