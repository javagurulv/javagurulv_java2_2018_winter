package lv.javaguru.java2.console.database;

import lv.javaguru.java2.console.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findByTitle(String title);

    void remove(Product product);

    List<Product> getAllProducts();

}
