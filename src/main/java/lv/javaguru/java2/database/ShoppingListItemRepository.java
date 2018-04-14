package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.ShoppingListItem;

public interface ShoppingListItemRepository {

    void save(ShoppingListItem shoppingListItem);

}
