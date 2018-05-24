package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.ShoppingList;
import lv.javaguru.java2.console.domain.User;

import java.util.Optional;

public interface ShoppingListRepository {

    void save(ShoppingList shoppingList);

    Optional<ShoppingList> findByUserAndTitle(User user, String title);

}
