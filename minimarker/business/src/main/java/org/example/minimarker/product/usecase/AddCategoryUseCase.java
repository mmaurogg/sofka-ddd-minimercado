package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.product.Product;
import org.example.minimarker.product.commands.AddCategoryCommand;

public class AddCategoryUseCase extends UseCase<RequestCommand<AddCategoryCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddCategoryCommand> input) {
        var command = input.getCommand();
        var product = Product.from(
                command.getProductId(), repository().getEventsBy(command.getProductId().value())
        );

        product.AddCategory(command.getCategoryId(), command.getTypeProduct());

        emit().onResponse(new ResponseEvents(product.getUncommittedChanges()));

    }
}
