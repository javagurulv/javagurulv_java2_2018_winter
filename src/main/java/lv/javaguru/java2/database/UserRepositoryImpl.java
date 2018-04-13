package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<ShoppingList> getShoppingLists(User user) {
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
