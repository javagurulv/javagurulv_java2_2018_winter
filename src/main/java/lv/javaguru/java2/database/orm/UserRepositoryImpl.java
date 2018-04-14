package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class UserRepositoryImpl extends ORMRepository
                         implements UserRepository {

    @Override
    public void save(User user) {
        session().save(user);
    }

    @Override
    public List<ShoppingList> findShoppingLists(User user) {
        String query = "from ShoppingList sl " +
                "where sl.user = :user";
        return session().createQuery(query)
                .setParameter("user", user)
                .list();

        /*return session().createCriteria(ShoppingList.class)
                .add(Restrictions.eq("user", user))
                .list();*/
    }

}
