package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.minimarker.product.commands.UpdateTypeOfCategoryCommand;
import org.example.minimarker.product.events.CategoryAdded;
import org.example.minimarker.product.events.ProductCreated;
import org.example.minimarker.product.events.TypeOfCategoryUpdated;
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
class UpdateTypeOfCategoryUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    UpdateTypeOfCategoryUseCase useCase;

    @Test
    public void whenATypeIsUpdatedInACategory() throws IllegalAccessException {
        ProductId productId = ProductId.of("pppp");
        CategoryId categoryId = CategoryId.of("cat");
        TypeProduct typeProduct = new TypeProduct("alta-rotacion");

        var command = new UpdateTypeOfCategoryCommand(productId, categoryId, typeProduct);
        when(repository.getEventsBy(productId.value())).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TypeOfCategoryUpdated)events.get(0);
        Assertions.assertEquals("alta-rotacion", event.typeProduct().value());
    }

    private List<DomainEvent> history() throws IllegalAccessException {

        SupplierId supplierId = new SupplierId("ssss");
        Name nameSupplier = new Name("supllierName");
        Name nameProduct = new Name("productName");
        ValueProduct valueProduct = new ValueProduct(200.0);

        CategoryId categoryId = CategoryId.of("cat");
        TypeProduct typeProduct = new TypeProduct("baja-rotacion");

        return List.of(
                new ProductCreated(supplierId, nameSupplier, nameProduct, valueProduct),
                new CategoryAdded(categoryId, typeProduct)
        );
    }

}