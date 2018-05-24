package lv.javaguru.java2.console.businesslogic.createshoppinglist;

import lv.javaguru.java2.console.businesslogic.Error;
import lv.javaguru.java2.console.domain.User;

import java.util.List;

public interface CreateShoppingListValidator {

    List<Error> validate(User user, CreateShoppingListRequest request);

}
