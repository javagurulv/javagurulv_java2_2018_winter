package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductInMemoryRepository implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Optional<Product> findByTitle(String title) {
/*
        for (Product product : products) {
            if (product.getTitle().equals(title)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
*/
        return products.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst();
    }

    @Override
    public void remove(Product product) {
        products.remove(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(products);
        return allProducts;
    }

}
