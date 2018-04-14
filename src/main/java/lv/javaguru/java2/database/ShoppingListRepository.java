package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.ShoppingList;

public interface ShoppingListRepository {

    void save(ShoppingList shoppingList);

}
