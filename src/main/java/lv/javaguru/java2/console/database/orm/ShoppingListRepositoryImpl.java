package lv.javaguru.java2.console.database.orm;

import lv.javaguru.java2.console.database.ShoppingListRepository;
import lv.javaguru.java2.console.domain.ShoppingList;
import lv.javaguru.java2.console.domain.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class ShoppingListRepositoryImpl extends ORMRepository
                                 implements ShoppingListRepository {

    @Override
    public void save(ShoppingList shoppingList) {
        session().save(shoppingList);
    }

    @Override
    public Optional<ShoppingList> findByUserAndTitle(User user,
                                                     String title) {
        ShoppingList shoppingList = (ShoppingList) session().createCriteria(ShoppingList.class)
                .add(Restrictions.eq("user", user))
                .add(Restrictions.eq("title", title))
                .uniqueResult();
        return Optional.ofNullable(shoppingList);
    }

}
