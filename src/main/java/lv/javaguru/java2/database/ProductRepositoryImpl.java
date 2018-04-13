package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductDatabase {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(Product product) {
        session().save(product);
    }

    @Override
    public Optional<Product> findByTitle(String title) {
        Product product = (Product) session().createCriteria(Product.class)
                .add(Restrictions.eq("title", title))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public void remove(Product product) {
        session().delete(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return session()
                .createCriteria(Product.class)
                .list();
    }

}
