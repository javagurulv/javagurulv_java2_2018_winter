package lv.javaguru.java2.businesslogic.createshoppinglist;

import lv.javaguru.java2.businesslogic.Error;
import lv.javaguru.java2.database.ShoppingListRepository;
import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class CreateShoppingListValidatorImpl implements CreateShoppingListValidator {

    @Autowired private ShoppingListRepository shoppingListRepository;

    @Override
    public List<Error> validate(User user,
                                CreateShoppingListRequest request) {
        List<Error> errors = new ArrayList<>();
        validateTitle(request.getTitle()).ifPresent(errors::add);
        validateDuplicateTitle(user, request.getTitle()).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            return Optional.of(new Error("title", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateDuplicateTitle(User user, String title) {
        if (title != null && !title.isEmpty()) {
            Optional<ShoppingList> shoppingListOpt = shoppingListRepository.findByUserAndTitle(user, title);
            if (shoppingListOpt.isPresent()) {
                return Optional.of(new Error("title", "Must not be repeated"));
            }
        }
        return Optional.empty();
    }

}
