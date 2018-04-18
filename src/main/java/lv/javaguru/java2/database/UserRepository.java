package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    List<ShoppingList> findShoppingLists(User user);

    Optional<User> findByLogin(String login);

}
