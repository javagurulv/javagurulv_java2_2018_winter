package lv.javaguru.java2.businesslogic.createshoppinglist;

import lv.javaguru.java2.businesslogic.Error;
import lv.javaguru.java2.domain.User;

import java.util.List;

public interface CreateShoppingListValidator {

    List<Error> validate(User user, CreateShoppingListRequest request);

}
