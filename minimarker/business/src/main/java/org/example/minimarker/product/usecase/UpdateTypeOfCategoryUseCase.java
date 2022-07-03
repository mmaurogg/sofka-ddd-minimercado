package org.example.minimarker.product.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.minimarker.product.Product;
import org.example.minimarker.product.commands.UpdateTypeOfCategoryCommand;

public class UpdateTypeOfCategoryUseCase extends UseCase<RequestCommand<UpdateTypeOfCategoryCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateTypeOfCategoryCommand> input) {
        var command = input.getCommand();
        var product = Product.from(
                command.getProductId(), repository().getEventsBy(command.getProductId().value())
        );

        product.updateTypeOfCategory(command.getCategoryId(), command.getTypeProduct());

        emit().onResponse(new ResponseEvents(product.getUncommittedChanges()));

    }
}
