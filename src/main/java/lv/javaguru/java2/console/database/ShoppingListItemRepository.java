package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.ShoppingListItem;

public interface ShoppingListItemRepository {

    void save(ShoppingListItem shoppingListItem);

}
