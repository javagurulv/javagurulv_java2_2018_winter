package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;

import java.util.List;

public interface UserRepository {

    List<ShoppingList> getShoppingLists(User user);

}
