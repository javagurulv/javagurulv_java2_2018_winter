package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;

import java.util.Optional;

public interface ShoppingListRepository {

    void save(ShoppingList shoppingList);

    Optional<ShoppingList> findByUserAndTitle(User user, String title);

}
