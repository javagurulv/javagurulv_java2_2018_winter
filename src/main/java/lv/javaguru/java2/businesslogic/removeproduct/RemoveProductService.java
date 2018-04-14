package lv.javaguru.java2.businesslogic.removeproduct;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.database.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveProductService {

    @Autowired private ProductRepository productDatabase;

    public boolean removeProduct(String title) {
        Optional<Product> foundProduct = productDatabase.findByTitle(title);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            productDatabase.remove(product);
            return true;
        } else {
            return false;
        }
    }

}
