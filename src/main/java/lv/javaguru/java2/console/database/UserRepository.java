package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.ShoppingList;
import lv.javaguru.java2.console.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    List<ShoppingList> findShoppingLists(User user);

    Optional<User> findByLogin(String login);

}
