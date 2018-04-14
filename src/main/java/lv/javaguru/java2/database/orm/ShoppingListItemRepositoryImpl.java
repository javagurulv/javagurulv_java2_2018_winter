package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.ShoppingListItemRepository;
import lv.javaguru.java2.domain.ShoppingListItem;
import org.springframework.stereotype.Component;

@Component
class ShoppingListItemRepositoryImpl extends ORMRepository
                                 implements ShoppingListItemRepository {

    @Override
    public void save(ShoppingListItem shoppingListItem) {
        session().save(shoppingListItem);
    }

}
