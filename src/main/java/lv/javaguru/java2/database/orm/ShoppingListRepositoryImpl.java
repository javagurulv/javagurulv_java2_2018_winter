package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.ShoppingListRepository;
import lv.javaguru.java2.domain.ShoppingList;
import org.springframework.stereotype.Component;

@Component
class ShoppingListRepositoryImpl extends ORMRepository
                                 implements ShoppingListRepository {

    @Override
    public void save(ShoppingList shoppingList) {
        session().save(shoppingList);
    }

}
