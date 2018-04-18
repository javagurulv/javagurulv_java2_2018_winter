package lv.javaguru.java2.businesslogic.createshoppinglist;

import lv.javaguru.java2.businesslogic.Error;
import lv.javaguru.java2.database.ShoppingListRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lv.javaguru.java2.domain.builders.ShoppingListBuilder.createShoppingList;

@Component
class CreateShoppingListServiceImpl implements CreateShoppingListService {

    @Autowired private UserRepository userRepository;
    @Autowired private ShoppingListRepository shoppingListRepository;
    @Autowired private CreateShoppingListValidator validator;

    @Override
    @Transactional
    public CreateShoppingListResponse create(CreateShoppingListRequest request) {
        // find user
        Optional<User> userOpt = userRepository.findByLogin(request.getUserLogin());
        if (!userOpt.isPresent()) {
            return new CreateShoppingListResponse(buildErrorListWithUserNotFoundError());
        }
        User user = userOpt.get();

        // validate
        List<Error> validationErrors = validator.validate(user, request);
        if (!validationErrors.isEmpty()) {
            return new CreateShoppingListResponse(validationErrors);
        }

        // create new shoppingList
        ShoppingList shoppingList = createShoppingList()
                .with(user)
                .withTitle(request.getTitle())
                .build();

        // store to db
        shoppingListRepository.save(shoppingList);

        return new CreateShoppingListResponse(shoppingList.getId());
    }

    private List<Error> buildErrorListWithUserNotFoundError() {
        Error error = new Error("userLogin", "Not found");
        List<Error> errors = new ArrayList<>();
        errors.add(error);
        return errors;
    }

}
